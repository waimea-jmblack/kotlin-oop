/**
 * Intro to OOP looking at the creation
 * and use of classes and objects
 */


/**
 * The main() method is the entry point for
 * any Kotlin program
 */
fun main() {
    //Lets make some cats
    val cat1 = Cat("Jimmy")
    val cat2 = Cat("Tate")
    val cat3 = Cat("Money")

    println(cat1)
    println(cat2)
    println(cat3)

    //Play with the cat
    cat1.poke()
    cat1.stroke()

    //Manipulate cat friendships
    println(cat1)
    cat1.makeFriends(cat3)
    println(cat1)

    //-------------------------------------------------------------------------------/

    /**
     * Room height, width and length is used to find volume and area
     */
    val room = Room(2,3,6)

    val volume = room.volume()
    println(volume)

    val area = room.area()
    println(area)


    //-------------------------------------------------------------------------------/

    /**
     * Person height, name and favorite color. Then she says it all in one sentence
     */
    val person = Person(1.85,"Jenny", "Green")

    val sayHello = person.sayHello()
    println(sayHello)

    val setOwner = person.setOwner()
    println(setOwner)

    //-------------------------------------------------------------------------------/


}

/**
 * Cat class tracking name and other key data
 * Cats can be woken, stroked, make friends, ect.
 */

class Cat(val name: String, var legs: Int = 4) {
        var isSleeping: Boolean = false
        var isHungry: Boolean = false
        var bff: Cat? = null //? allows us to make the cat/ object null/ not an object

        //Method that updates state
        //Poking the cat
        fun poke() {
            // Was the cat asleep?
            if (isSleeping) {
                //Wake it up
                isSleeping = false
            }
            else {
                println("$name is angry and scratches you")
            }
        }

        //Method that
        //Stroking the Cat
        fun stroke() {
            // Was the cat awake?
            if (!isSleeping) { //! means false (if it's not sleeping)
                //If so then falls asleep
                isSleeping = true
                println("$name falls asleep")
            }
            else {
                println("$name is happy and purs ")
            }
        }

        //Method where data is supplied
        fun makeFriends(newFriend: Cat) {
            bff = newFriend         // Connect them from us
            newFriend.bff = this    // Connect back to us ('this')

            println("$name is now friends with ${newFriend.name}")
        }

    //-------------------------------------------------------------------------------/

        // This method is run when an object is created
        init {
            println("Creating a new cat")
        }

        // This replaces the default function
        // that prints the objects id with something more useful
        override fun toString(): String {
            var info: String = ""

            info += "Name: $name\n"
            info += "Legs: $legs\n"
            info += "Hungry: $isHungry\n"
            info += "Sleeping: $isSleeping\n"
            if (bff != null) {
                info += "Bff: ${bff!!.name}"    //!! means that this is definitely no a null
            }
            else {
                info += "No BFF!"
            }

          return info
        }
    }

    //-------------------------------------------------------------------------------/


    /**
     * Room class defining a physical room with, height, width and distance/length
     */
    class Room(val height: Int, val width: Int, val length: Int) {
            fun volume(): Int {
                return (height * width * length)
            }

            fun area(): Int {
                return (width * length)

            }
        }

    //-------------------------------------------------------------------------------/


/**
 * Person Class defining a persons attributes with, name, favorite colour and height
 */
    class Person(val elevation: Double, val forename: String, val favColor: String) {
    var owner: Person? = null //? allows us to make the cat/ object null/ not an object
        fun sayHello() =
            println("Hi, I'm $forename, I'm $elevation meters tall and I like the color $favColor")

    fun setOwner(newOwner: Person) {
        owner = newOwner // Connect them from us
        newOwner.owner = this // Connect back to us ('this')

        println("$forename now owns a ${newOwner.forename}")
    }
}
