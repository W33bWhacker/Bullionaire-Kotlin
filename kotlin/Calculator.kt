// Class that controls all useful mathematical calculations
class Calculator {

    fun getMetalContent(weight: Double, purity: Double): Double {

        return weight * purity
    }

    fun face2Weight(face: Double, dealer: Dealer): Double {

        val num: Double = face / dealer.junk.value
        return getMetalContent(num, dealer.junk.content)
    }

    fun per2Dec(percent: Int): Double {

        return (percent / 100).toDouble()
    }

    fun getItemOz(spot: Double, price: Double, weight: Double): Double {

        return price * (spot / (spot * weight))
    }

    fun getOverSpot(spot: Double, price: Double, weight: Double): Double {

        return getItemOz(spot, price, weight) - spot
    }

    fun gram2oz(dealer: Dealer, gram: Double): Double {

        return gram * dealer.constant.oz
    }

    fun oz2Gram(dealer: Dealer, oz: Double): Double {

        return oz * dealer.constant.gram
    }

}