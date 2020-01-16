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


open class Account {
    private var amount: Double = 0.toDouble()

    open fun topUP(amount: Double) {
        if (amount > 0) {
            this.amount += amount
        } else
            println("Пополнить счет можно только на положительную сумму")
    }

    open fun withDraw(amount: Double) {
        if (amount > 0) {
            this.amount -= amount
        } else
            println("Снять со счета можно только положительную сумму")
    }

    fun showBalance() {
        println("Баланс счета составляет $amount")
    }

}



//нельзя снимать деньги в течении месяца с последнего внесения
class DepositAccount : Account() {
    private var calendarLastTopUp: Calendar? = null

    override fun topUP(amount: Double) {
        calendarLastTopUp = Calendar.getInstance()
        super.topUP(amount)
    }

    override fun withDraw(amount: Double) {
        val currentCalendar = Calendar.getInstance()
        currentCalendar.add(Calendar.MONTH, -1)
        if (calendarLastTopUp != null) {
            if (calendarLastTopUp!!.before(currentCalendar)) {
                super.withDraw(amount)
            } else
                println("Со времени последнего внесения прошло меньше месяца, снятие невозможно")
        } else
            super.withDraw(amount)

    }
}





//карточный счет - комиссия при снятии 1%
class CardAccount : Account() {
    override fun withDraw(amount: Double) {
        super.withDraw(amount * 1.01)
    }
}