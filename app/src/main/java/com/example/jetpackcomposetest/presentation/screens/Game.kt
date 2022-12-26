package com.example.jetpackcomposetest.presentation.screens

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.jetpackcomposetest.data.Bug
import com.example.jetpackcomposetest.data.Player
import com.example.jetpackcomposetest.utils.AppConstants
import androidx.compose.ui.viewinterop.AndroidViewBinding
import androidx.core.view.isVisible
import com.example.jetpackcomposetest.R
import com.example.jetpackcomposetest.databinding.FragmentGameBinding

private const val COUNT_CUP_DEFAULT_VALUE = "3"
private const val ONE_CUP = 1
private const val CUP_RAN_OUT_VALUE = 0
private const val ONE = 1
private const val FAILURE = 0
private const val FIVE_POINTS = 5
private const val SIX_POINTS = 6
private const val MIN_DICE_VALUE = 1
private const val MAX_DICE_VALUE = 6
private const val ZERO_HP_POINTS = 0

@Composable
fun Game(navController: NavController) {
    val context = LocalContext.current

    val player =
        navController.previousBackStackEntry?.savedStateHandle?.get<Player>(AppConstants.BUNDLE_KEY_PLAYER)
    val bug =
        navController.previousBackStackEntry?.savedStateHandle?.get<Bug>(AppConstants.BUNDLE_KEY_MONSTER)

    LaunchedEffect(key1 = player, key2 = bug) {
        Log.d("params", "$player")
        Log.d("params", "$bug")
    }

    AndroidViewBinding(FragmentGameBinding::inflate) {

        fun initParameters() {
            player?.apply {
                tvAttackPlayer.text = String.format(context.getString(R.string.attack), attack)
                tvProtectionPlayer.text =
                    String.format(context.getString(R.string.protection), protection)
                tvHealthPlayerValue.text = health.toString()
                tvAttackModifierPlayer.text = String.format(
                    context.getString(R.string.attack_modifier), player.calculateAttackModifier(
                        attackersAttack = attack,
                        defenderDefense = bug!!.protection
                    )
                )
                tvDamagePlayer.text =
                    String.format(context.getString(R.string.damage), minDamage, maxDamage)
                countCups.text = COUNT_CUP_DEFAULT_VALUE
            }

            bug?.apply {
                tvAttackMonster.text = String.format(context.getString(R.string.attack), attack)
                tvProtectionMonster.text =
                    String.format(context.getString(R.string.protection), protection)
                tvHealthMonsterValue.text = health.toString()
                tvAttackModifierMonster.text = String.format(
                    context.getString(R.string.attack_modifier), bug.calculateAttackModifier(
                        attackersAttack = attack,
                        defenderDefense = player!!.protection
                    )
                )
                tvDamageMonster.text =
                    String.format(context.getString(R.string.damage), minDamage, maxDamage)
            }
        }

        fun healAvailable() {
            actionHealCardView.isEnabled = countCups.text.toString().toInt() > CUP_RAN_OUT_VALUE
        }

        fun healUser() {
            actionHealCardView.setOnClickListener {
                player?.apply {
                    val currentCupsCount = countCups.text.toString().toInt()
                    countCups.text = (currentCupsCount - ONE_CUP).toString()
                    val healResult: Int
                    val healthAfterTreatment =
                        tvHealthPlayerValue.text.toString().toInt() + maxHealth / 2
                    healResult =
                        if (healthAfterTreatment > maxHealth) maxHealth else healthAfterTreatment
                    tvHealthPlayerValue.text = healResult.toString()
                    healAvailable()
                }
            }
        }

        fun strike(
            minAttackerDamage: Int,
            maxAttackerDamage: Int,
            attackerAttackModifier: Int
        ): Int {
            val result: Int
            val list: ArrayList<Int> = ArrayList()
            for (dice in ONE..attackerAttackModifier) {
                val res = (MIN_DICE_VALUE..MAX_DICE_VALUE).random()
                list.add(res)
            }
            result = if (list.contains(FIVE_POINTS) || list.contains(SIX_POINTS)) {
                (minAttackerDamage..maxAttackerDamage).random()
            } else FAILURE
            return result
        }

        fun monsterDiedCheck() {
            if (tvHealthMonsterValue.text.toString().toInt() <= ZERO_HP_POINTS) {
                fragmentVictory.root.isVisible = true
                fragmentDefeat.root.isVisible = false
                gameContent.isVisible = false
                fragmentVictory.newGameButton.setOnClickListener {
                    navController.navigateUp()
                }
            }
        }

        fun playerDiedCheck() {
            if (tvHealthPlayerValue.text.toString().toInt() <= ZERO_HP_POINTS) {
                fragmentVictory.root.isVisible = false
                fragmentDefeat.root.isVisible = true
                gameContent.isVisible = false
                fragmentDefeat.newGameButton.setOnClickListener {
                    navController.navigateUp()
                }
            }
        }

        fun throwDiceAction() {

            throwDiceBtn.setOnClickListener {

                /** Сколько урона нанес игрок **/

                val playerRollResult = strike(
                    minAttackerDamage = player!!.minDamage,
                    maxAttackerDamage = player.maxDamage,
                    player.calculateAttackModifier(
                        attackersAttack = player.attack,
                        defenderDefense = bug!!.protection
                    )
                )

                tvDamagePlayerAfterThrow.text = playerRollResult.toString()

                /** Обновление значения здоровья игрока **/

                tvHealthMonsterValue.text =
                    (tvHealthMonsterValue.text.toString().toInt() - playerRollResult).toString()

                /** Был ли успешным ход игрока **/

                if (playerRollResult != FAILURE) tvRollResultPlayerValue.text =
                    context.getString(R.string.lucky) else tvRollResultPlayerValue.text =
                    context.getString(R.string.failure)

                /** Сколько урона нанес монстр **/

                if (tvHealthMonsterValue.text.toString().toInt() > ZERO_HP_POINTS) {
                    val monsterRollResult = strike(
                        minAttackerDamage = bug.minDamage,
                        maxAttackerDamage = bug.maxDamage,
                        bug.calculateAttackModifier(
                            attackersAttack = bug.attack,
                            defenderDefense = player.protection
                        )
                    )

                    tvDamageMonsterAfterThrow.text = monsterRollResult.toString()

                    /** Обновление значения здоровья монстра **/

                    tvHealthPlayerValue.text =
                        (tvHealthPlayerValue.text.toString().toInt() - monsterRollResult).toString()

                    /** Был ли успешным ход монстра **/

                    if (monsterRollResult != FAILURE) tvRollResultMonsterValue.text =
                        context.getString(R.string.lucky) else tvRollResultMonsterValue.text =
                        context.getString(R.string.failure)
                }

                /** закончилась ли игра **/

                monsterDiedCheck()
                playerDiedCheck()
            }
        }

        initParameters()
        healUser()
        throwDiceAction()
    }
}

