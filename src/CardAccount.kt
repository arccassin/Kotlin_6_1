/**
 * Created by User on 17 Янв., 2020
 */
//карточный счет - комиссия при снятии 1%
class CardAccount : Account() {
    override fun withDraw(amount: Double) {
        super.withDraw(amount * 1.01)
    }
}