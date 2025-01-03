package com.aklabs.mytestkotlin

import java.util.Objects

fun main() {
//when loop
//    var num=9
//    var result=when(num){
//
//        1->"One"
//        2-> "Two"
//        9->"Nine"
//        else-> "Non Zero"}
//var res=if(num==9) print("Num is Correct ")else print("Num is not nine")
//
//    print(result)
//    print(res)


    //while loop
//    var number=2
//    var index=1
//    while(index<=10)
//    {
//        println(number*index)
//        index++
//
//
//    }

    //Do while loop
//    var number = 5
//    var index = 1
//
//    do {
//        println(number * index)
//        index++
//    } while (index <= 10)

    //forloop

    var num = 5
    var index = 1
//    for(i in 1..8 step 2) println(i)
//    println("until")
//    for(i in 1 until 7) println(i)
//    println("Downto")
//    for(i in 10 downTo 2 step 4 ) println(i)

//    for(i in  1..10)
//
//        println(num.toString() + " X" + i + " = " + (num*i))

//print(addnum(4,6)
//print(addnum(4,6))
//println(addnum())
//var fu= ::addition
//println(fu(33,4))

//}
//Inline functions
//fun addnum(a:Int , b :Int):Int =a+b
//fun addnum(a:Int=4,b:Int=5)=a+b
//
//fun addition(a:Int,b:Int):Int{
//    return a+b;


//var array= arrayOf("Aniket","Aditya","Vikas","Makrand")
//    var arraye= arrayOf(1,4,5,6)
//    var arry2= arrayOf<Int>(2,3, 4.5.toInt())
//
//    for((i,e) in arry2.withIndex()){
//        println("$i- $e")
//    }
//

//    var mems=Car("Skoda","Diesel",340000)
//    var roude=Car("Honda","Petrol",45000)
//    print(mems.Type)
//    print(mems.name)
//    print(mems.carKM)
//    val shape = Shape()
//    val circle = Circle(4.5)
//    printArea(circle)


//    val shapes=Circle(4.5)
//    println(shapes.radius)
//    println(shapes.display())
//dragobjects(arrayOf(Circle(4.0),Square(5.0),Triangle(2.0,3.0)))

//
//    SharingWidget.incrementsTwitterlikes()
//    SharingWidget.incrementsTwitterlikes()
//    SharingWidget.incrementsTwitterlikes()
//    SharingWidget.incrementsTwitterlikes()
//    SharingWidget.incrementFblikes()
//    SharingWidget.display()
//    val nums=Valid.FRIDAY
//    print(nums)

 val tile:Tile=Red("Mushroom",35)
 val points=when(tile)
 {
     is Green -> tile.Points*2
     is Red -> tile.Points*3
 }
    println(points)



}
//


sealed class Tile
class Red(val type:String,val Points:Int):Tile()
class Green(val Points:Int):Tile()





enum class Valid(val valuee:Int){

    SUNDAY(1),
    MONDAY(2),
    TUESDAY(3),
    WEDNESDAY(4),
    THURSEDAY(5),
    FRIDAY(6),
    SATUERDAY(7);





}







object SharingWidget{

   private var twitterlikes=0
   private var fblikes=0
    fun incrementsTwitterlikes()= twitterlikes++
    fun incrementFblikes()= fblikes++
    fun display()= println("Facebook - $fblikes -- Twitter $twitterlikes")

}








fun printArea(shapes: Shape) {
    println(shapes.area())
}
fun dragobjects(objects:Array<Dragable>)
{
    for (objectss in objects){
        objectss.drag()

    }
}



interface Dragable{


    fun drag()
}

abstract  class Shape :Dragable{

     abstract fun area(): Double


}






class Circle(val radius: Double) : Shape() {
    override fun area(): Double = Math.PI * radius * radius
    override fun drag() {
        println("Circle is Dragging")
    }
}
class Square(val side: Double) : Shape() {
    override fun area(): Double = side * side
    override fun drag() {
        println("Square is Dragging")
    }
}

class Triangle(val base: Double, val height: Double) : Shape() {
    override fun area(): Double = 0.5 * base * height
    override fun drag() {
        println("Triangle is Dragging")
    }
}


class Car(var name: String, var Type: String, var carKM: Int) {

    fun drivecar() {
        print("Driving the Car")
    }

    fun applyBreak() {

        print("Applying the break")
    }


}





