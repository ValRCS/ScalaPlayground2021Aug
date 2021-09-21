package com.github.valrcs

import com.github.valrcs.ReadingJSON.rawString
import upickle.default._
import upickle._

import scala.collection.mutable
import scala.io.Source

object ExerciseSep21ReadJSON extends App {
  //TODO read raw recipes.json
  val recipePath = "src/resources/json/recipes.json"
  val bufferedSource = Source.fromFile(recipePath)
  val rawString = bufferedSource.mkString("")
  println(rawString)

  //TODO parse using upickle into upickle value type
  val data = ujson.read(rawString) //here ujson parses the raw text into some structure
  println(data(1)("title")) //so 2nd recipe value of the key: "title"
//  println(data(1)("noSuchtitle")) //so 2nd recipe value of the key: "title"

  //TODO convert to Array of Values
  val arrValues = data.arr.toArray //arr was giving ArrayBuffer but I want fixed size
  println(arrValues(0))

  //TODO convert to Array of HashMaps(you do not need to convert fully
  val seqObjects = arrValues.map(myValue => myValue.obj)
  seqObjects.slice(0,3).foreach(println)


  //TODO print the recipes out

  def createRecipe(hMap: mutable.LinkedHashMap[String, ujson.Value]): Recipe = {
    val title = hMap.getOrElse("title", "no title").toString
    val href = hMap.getOrElse("href", "no url").toString
    val ingredients = hMap.getOrElse("ingredients", "").toString.split(",")
    val thumbnail = hMap.getOrElse("thumbnail", "no thumb").toString
    Recipe(title, href, ingredients, thumbnail)
  }

  val firstRecipe = createRecipe(seqObjects.head) //or seqObjects(0)
  println(firstRecipe)
  println(firstRecipe.ingredients.mkString(","))
  //BONUS create a Recipe case class and actually parse into Array of Recipe s //this could take a bit longer

//  val allRecipes = seqObjects.map(hMap => createRecipe(hMap)) //full syntax
//    val allRecipes = seqObjects.map(createRecipe(_)) //shorter
  val allRecipes = seqObjects.map(createRecipe) //super short, works because createRecipe only takes one parameter of cour type

  allRecipes.slice(0,3).foreach(println)

  val jsonText = write(firstRecipe)
  println(jsonText)

  val allRecipeJson = write(allRecipes)
  println(allRecipeJson)

  //so we made a funtion to check for ingredient
  def isNeedlePresent(ingredients: Array[String], needle:String):Boolean = {
    val goodIngredients = ingredients.filter(item => item.contains(needle))
    goodIngredients.length > 0 //so if 0 that will be false meaning no needle present
  }

//  val onionRecipes = allRecipes.filter(recipe => recipe.ingredients.contains(" onions"))
  val onionRecipes = allRecipes.filter(recipe => isNeedlePresent(recipe.ingredients, "onion"))
  println(onionRecipes.length)
  onionRecipes.foreach(println)

  val onionJSON = write(onionRecipes, indent = 4) //indent for human readability

  Utilities.saveText( "src/resources/json/onions.json", onionJSON)
}
