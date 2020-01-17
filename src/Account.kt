/**
 * Created by User on 17 Янв., 2020
 */
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