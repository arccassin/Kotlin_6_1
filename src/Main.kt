import java.util.*

/**
 * Created by User on 16 Янв., 2020
 */

fun main(args: Array<String>) {
    val account = Account()
    account.topUP(1100.0)
    account.withDraw(200.0)
    account.showBalance()

    val depositAccount = DepositAccount()
    //        depositAccount.topUP(1000);
    depositAccount.withDraw(300.0)
    depositAccount.showBalance()

    val cardAccount = CardAccount()
    cardAccount.topUP(1001.0)
    cardAccount.withDraw(100.0)
    cardAccount.showBalance()
}
