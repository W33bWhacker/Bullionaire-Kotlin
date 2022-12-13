// Class handling methods that a bullion dealer would in person
// like weighing metals and determining its worth.

import java.util.*

class Dealer {

    var spot = 0.0
    var types = ArrayList<String>()
    var weights = ArrayList<Double>()
    var prices = ArrayList<Double>()

    val scan = Scanner(System.`in`)
    var constant = Constants()
    var calc = Calculator()
    var junk = Constitutional()

    fun getUnit(): String {

        println("\nGram or Oz?\n")
        return scan.next()
    }

    fun getWeight(): Double {

        println("\nEnter weight:\n")
        return scan.nextFloat().toDouble()
    }

    fun getFace(): Double {

        println("\nEnter face value ($):\n")
        return scan.nextFloat().toDouble()
    }

    fun getPrice(): Double {

        println("\nItem price ($):\n")
        return scan.nextFloat().toDouble()
    }

    fun getKarat(): Double {

        println("\nKarat:\n")
        val karat = scan.nextInt()
        var purity = 0.0
        if (karat == 24) {
            purity = constant.k24
        } else if (karat == 22) {
            purity = constant.k22
        } else if (karat == 18) {
            purity = constant.k18
        } else if (karat == 14) {
            purity = constant.k14
        } else if (karat == 10) {
            purity = constant.k10
        } else if (karat == 9) {
            purity = constant.k9
        }
        return purity
    }

    fun getJunkValues(value: String) {

        if (value == "dollar" || value == "1") {
            junk.value = constant.dollar
            junk.content = constant.dollarContent
            junk.percent = constant.genPercent
        } else if (value == "90% half dollar" || value == "90 half dollar" || value == "2") {
            junk.value = constant.halfDollar
            junk.content = constant.halfContent90
            junk.percent = constant.genPercent
        } else if (value == "40% half dollar" || value == "40 half dollar" || value == "3") {
            junk.value = constant.halfDollar
            junk.content = constant.halfContent40
            junk.percent = constant.half40Percent
        } else if (value == "quarter" || value == "4") {
            junk.value = constant.quarter
            junk.content = constant.quarterContent
            junk.percent = constant.genPercent
        } else if (value == "dime" || value == "5") {
            junk.value = constant.dime
            junk.content = constant.dimeContent
            junk.percent = constant.genPercent
        } else if (value == "nickel" || value == "6") {
            junk.value = constant.nickel
            junk.content = constant.nickelContent
            junk.percent = constant.nickelPercent
        }
    }
}