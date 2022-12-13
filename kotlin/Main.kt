import java.util.Scanner

object Main {

    fun checkMetalName(metal: Metal): String {

        if (metal.name == "1") {
            metal.name = "gold"
        } else if (metal.name == "2") {
            metal.name = "silver"
        } else if (metal.name == "3") {
            metal.name = "platinum"
        } else if (metal.name == "4") {
            metal.name = "palladium"
        } else if (metal.name == "5") {
            metal.name = "rhodium"
        } else if (metal.name == "6") {
            metal.name = "copper"
        }
        return metal.name
    }

    @JvmStatic
    fun main(args: Array<String>) {

        val scan = Scanner(System.`in`)
        val metal = Metal()
        val dealer = Dealer()

        println(
            """
        ____   __ __  _      _      ____  ___   ____    ____  ____  ____     ___ 
       |    \ |  |  || |    | |    |    |/   \ |    \  /    ||    ||    \   /  _]
       |  o  )|  |  || |    | |     |  ||     ||  _  ||  o  | |  | |  D  ) /  [_ 
       |     ||  |  || |___ | |___  |  ||  O  ||  |  ||     | |  | |    / |    _]
       |  O  ||  :  ||     ||     | |  ||     ||  |  ||  _  | |  | |    \ |   [_ 
       |     ||     ||     ||     | |  ||     ||  |  ||  |  | |  | |  .  \|     |
       |_____| \__,_||_____||_____||____|\___/ |__|__||__|__||____||__|\_||_____|
       
       """.trimIndent()
        )
        try {
            Thread.sleep(2000)
        } catch (e: InterruptedException) {
            Thread.currentThread().interrupt()
        }
        println(
            """

                     ||``````````````````````````````````````````||
                     || Compare Seller Values of Precious Metals ||
                     ||__________________________________________||
        
        """.trimIndent()
        )
        try {
            Thread.sleep(2000)
        } catch (e: InterruptedException) {
            Thread.currentThread().interrupt()
        }
        println(
            """
        Choose Precious Metal:

        1. Gold
        2. Silver
        3. Platinum
        4. Palladium
        5. Rhodium
        6. Copper ... if you're into that.
        
        """.trimIndent()
        )
        val choice = scan.next()
        choice.lowercase()
        metal.name = choice
        checkMetalName(metal)
        println("\nNumber of comparisons:\n")
        val comparisons = scan.nextInt()
        var counter = 0
        while (counter < comparisons) {
            if (metal.name == "silver") {
                println(
                    """

                Bullion Type: 

                1. Coin, Round, Bar
                2. Junk (Constitutional)
                3. Jewelry
                4. Other
                
                """.trimIndent()
                )
            } else if (metal.name == "gold" || metal.name == "platinum") {
                println(
                    """

                Bullion Type: 

                1. Coin, Round, Bar
                2. Jewelry
                3. Other
                
                """.trimIndent()
                )
            } else if (metal.name == "palladium") {
                println(
                    """

                Bullion Type: 

                1. Coin, Bar
                2. Other
                
                """.trimIndent()
                )
            } else if (metal.name == "rhodium") {
                println(
                    """

                Bullion Type: 

                1. Bar
                2. Other
                
                """.trimIndent()
                )
            } else if (metal.name == "copper") {
                println(
                    """

                Bullion Type: 

                1. Round, Bar
                2. Pennies
                3. Other
                
                """.trimIndent()
                )
            }
            val type = scan.next()
            type.lowercase()
            metal.type = type
            if (metal.name == "gold" || metal.name == "platinum") {
                if (metal.type == "coin" || metal.type == "1" || metal.type == "round" || metal.type == "bar" || metal.type == "other" || metal.type == "3") {
                    metal.unit = dealer.getUnit()
                    metal.weight = dealer.getWeight()
                } else if (metal.type == "jewelry" || metal.type == "2") {
                    metal.unit = dealer.getUnit()
                    val jewelWeight: Double = dealer.getWeight()
                    metal.purity = dealer.getKarat()
                    metal.weight = dealer.calc.getMetalContent(jewelWeight, metal.purity)
                }
            } else if (metal.name == "silver") {
                if (metal.type == "coin" || metal.type == "1" || metal.type == "round" || metal.type == "bar") {
                    metal.unit = "oz"
                    metal.weight = dealer.getWeight()
                } else if (metal.type == "junk" || metal.type == "2") {
                    println(
                        """

                    Denomination:
                    
                    1. Dollar
                    2. 90% Half Dollar
                    3. 40% Half Dollar
                    4. Quarter
                    5. Dime
                    6. Nickel
                    7. Combo (excludes less than 90% silver content)
                    
                    """.trimIndent()
                    )
                    val denom = scan.next()
                    denom.lowercase()
                    dealer.getJunkValues(denom)
                    if (denom == "combo" || denom == "7") {
                        val coinWeight: Double = dealer.getWeight()
                        metal.weight = dealer.calc.getMetalContent(coinWeight, dealer.constant.genPercent)
                    } else {
                        println("\nWeight or Face?\n")
                        val amount = scan.next()
                        amount.lowercase()
                        if (amount == "weight") {
                            metal.unit = dealer.getUnit()
                            val coinWeight: Double = dealer.getWeight()
                            metal.weight = dealer.calc.getMetalContent(coinWeight, dealer.junk.percent)
                        } else if (amount == "face") {
                            val face: Double = dealer.getFace()
                            metal.unit = "oz"
                            metal.weight = dealer.calc.face2Weight(face, dealer)
                        }
                    }
                } else if (metal.type == "jewelry" || metal.type == "3") {
                    metal.unit = dealer.getUnit()
                    val jewelWeight: Double = dealer.getWeight()
                    println("Purity (%): ")
                    val percent = scan.nextInt()
                    val purity = dealer.calc.per2Dec(percent)
                    metal.weight = dealer.calc.getMetalContent(jewelWeight, purity)
                } else if (metal.type == "other" || metal.type == "4") {
                    metal.unit = dealer.getUnit()
                    metal.weight = dealer.getWeight()
                }
            } else if (metal.name == "palladium") {
                if (metal.type == "coin" || metal.type == "1" || metal.type == "bar") {
                    metal.unit = dealer.getUnit()
                    metal.weight = dealer.getWeight()
                } else if (metal.type == "other" || metal.type == "2") {
                    metal.unit = dealer.getUnit()
                    metal.weight = dealer.getWeight()
                }
            } else if (metal.name == "rhodium") {
                if (metal.type == "1" || metal.type == "bar") {
                    metal.unit = "oz"
                    metal.weight = dealer.getWeight()
                } else if (metal.type == "other" || metal.type == "2") {
                    metal.unit = dealer.getUnit()
                    metal.weight = dealer.getWeight()
                }
            } else if (metal.name == "copper") {
                if (metal.type == "round" || metal.type == "1" || metal.type == "bar") {
                    metal.unit = "oz"
                    metal.weight = dealer.getWeight()
                } else if (metal.type == "pennies" || metal.type == "2") {
                    metal.unit = dealer.getUnit()
                    val pennyWeight: Double = dealer.getWeight()
                    metal.weight = dealer.calc.getMetalContent(pennyWeight, dealer.constant.pennyPercent)
                } else if (metal.type == "other" || metal.type == "2") {
                    metal.unit = dealer.getUnit()
                    metal.weight = dealer.getWeight()
                }
            }
            val price: Double = dealer.getPrice()
            dealer.prices.add(price)
            metal.price = price
            dealer.types.add(metal.type)
            if (metal.unit == "gram") {
                metal.weight = dealer.calc.gram2oz(dealer, metal.weight)
                dealer.weights.add(metal.weight)
            } else {
                dealer.weights.add(metal.weight)
            }
            counter++
        }
        println(
            """
Current market price of ${metal.name.replaceFirstChar { it.uppercase() }} ($):
"""
        )
        val spot = scan.nextFloat().toDouble()
        dealer.spot = spot

        println(
            """
                
                ${metal.name.replaceFirstChar { it.uppercase() }}:
                """.trimIndent()
        )
        for (i in dealer.weights.indices) {
            System.out.printf(
                "\t" + dealer.types[i].replaceFirstChar { it.uppercase() } + ": $" + String.format(
                    "%.2f",
                    dealer.prices[i]
                ) + ", " + String.format("%.2f", dealer.weights[i]) + " Troy Oz"
            )
            System.out.printf(
                ", $" + String.format(
                    "%.2f", dealer.calc.getItemOz(
                        spot,
                        dealer.prices[i], dealer.weights[i]
                    )
                ) + " per Oz, $" + String.format(
                    "%.2f", dealer.calc.getOverSpot(
                        spot, dealer.prices[i],
                        dealer.weights[i]
                    )
                ) + " Over spot\n"
            )
            println("\n")
        }
        scan.close()
    }
}