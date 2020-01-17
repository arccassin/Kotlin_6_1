import java.util.*

/**
 * Created by User on 17 Янв., 2020
 */
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