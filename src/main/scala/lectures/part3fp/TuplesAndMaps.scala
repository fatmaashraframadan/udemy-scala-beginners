package lectures.part3fp

import scala.collection.immutable.ListMap


object TuplesAndMaps extends App {

  val aTuple = (2, "Fatma")
  println(aTuple._1)
  println(aTuple._2)

  println(aTuple.copy(_2 = "test2"))
  println(aTuple.swap)

  //Maps
  val aMap: Map[String, Int] = Map()

  val phoneBook = Map("Fatma" -> 123, "Sarah" -> 456).withDefaultValue(-1)
  println(phoneBook)

  println(phoneBook.contains("Fatma"))
  println(phoneBook.contains("fatma"))

  println(phoneBook("fatma"))

  val newPair = "Omar" -> 2020
  val newPhoneBook = phoneBook + newPair

  println(newPhoneBook)


  //Functionals on Maps
  //Map , flatmap, filter

  println(phoneBook.map(pair => pair._1.toLowerCase -> pair._2))
  println(phoneBook.view.filterKeys(x => x.startsWith("F")).toMap)

  println(phoneBook.view.mapValues(number => "1234-" + number).toMap)

  //Conversions to other collections
  println(phoneBook.toList)
  println(List((222, "Fatma")).toMap)

  val names = List("Fatma", "Ahmed", "Sarah", "DOmara", "Alyaa", "Farida")
  println(names.groupBy(name => name.contains("a")))


  /*
  1.  What would happen if I had two original entries "Jim" -> 555 and "JIM" -> 900
      !!! careful with mapping keys.
  2.  Overly simplified social network based on maps
      Person = String
      - add a person to the network
      - remove
      - friend (mutual)
      - unfriend
      - number of friends of a person
      - person with most friends
      - how many people have NO friends
      - if there is a social connection between two people (direct or not)
 */


  //Add Person
  def add(socialNetwork: Map[String, Set[String]], person: String): Map[String, Set[String]] = {
    socialNetwork + (person -> Set())
  }

  //friend
  def friend(socialNetwork: Map[String, Set[String]], personA: String, personB: String): Map[String, Set[String]] = {
    val x = socialNetwork(personA) + personB
    val x2 = socialNetwork(personB) + personA

    socialNetwork + (personA -> x) + (personB -> x2)
  }

  //unfriend
  def unfriend(socialNetwork: Map[String, Set[String]], personA: String, personB: String): Map[String, Set[String]] = {
    val x = socialNetwork(personA) - personB
    val x2 = socialNetwork(personB) - personA

    socialNetwork + (personA -> x) + (personB -> x2)
  }

  //remove
  def remove(socialNetwork: Map[String, Set[String]], person: String): Map[String, Set[String]] = {
    //Need to remove this person's friendships before removing this person
    // So needs auxiliary function
    def removeAux(friends: Set[String], NetworkAcc: Map[String, Set[String]]): Map[String, Set[String]] = {
      if (friends.isEmpty) NetworkAcc
      else {
        removeAux(friends.tail, unfriend(NetworkAcc, person, friends.head))
      }
    }

    val unfriended = removeAux(socialNetwork(person), socialNetwork)
    unfriended - person
  }

  val empty: Map[String, Set[String]] = Map()
  val network = add(add(empty, "Omar"), "Fatma")

  println(friend(network, "Fatma", "Omar"))

  println(unfriend(friend(network, "Fatma", "Omar"), "Fatma", "Omar"))
  println(remove(friend(network, "Fatma", "Omar"), "Omar"))


  val people = add(add(add(empty, "Jim"), "Mary"), "Bob")
  val jimBob = friend(people, "Bob", "Jim")
  val MaryBob = friend(jimBob, "Bob", "Mary")

  println(MaryBob)

  def nFriends(network: Map[String, Set[String]], person: String): Int = {
    if (!network.contains(person)) 0
    else network(person).size
  }

  println(nFriends(MaryBob, "Bob"))

  def mostFriends(network: Map[String, Set[String]]): String = {
    network.maxBy(pair => pair._2.size)._1
  }

  println(mostFriends(MaryBob))

  def nPeopleWithNoFriends(network: Map[String, Set[String]]): Int = {
    network.count(pair => pair._2.isEmpty)
  }

  println(nPeopleWithNoFriends(MaryBob))

  def socialConnection(network: Map[String, Set[String]], personA: String, personB: String): Boolean = {
    def BFS(target: String, consideredPeople: Set[String], discoveredPeople: Set[String]): Boolean = {
      if (discoveredPeople.isEmpty) false
      else {
        val person = discoveredPeople.head

        if (person == target) true
        else if (consideredPeople.contains(person)) BFS(target, consideredPeople, discoveredPeople.tail)
        else BFS(target, consideredPeople + person, discoveredPeople ++ network(person))
      }
    }

    BFS(personB, Set(), network(personA) + personA)
  }

  println(socialConnection(network, "Omar", "Fatma"))
}
