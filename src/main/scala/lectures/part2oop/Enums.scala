package lectures.part2oop

object Enums {
  enum Permissions {
    case READ, WRITE, EXECUTE, NONE

    def openDocument: Unit = {
      if (this == READ) println("Reading")
      else println("Reading not allowed")
    }
  }


  enum PermissionWithBits(bits: Int) {
    case READ extends PermissionWithBits(4)
    case WRITE extends PermissionWithBits(2)
    case EXECUTE extends PermissionWithBits(1)
    case NONE extends PermissionWithBits(0)
  }

  object PermissionWithBits {
    def fromBits(bits: Int): PermissionWithBits = {
      PermissionWithBits.NONE
    }
  }

  val somePermission: Permissions = Permissions.READ
  val somePermissionsOrdinal = somePermission.ordinal
  val allPermissions = PermissionWithBits.values
  val readPermission: Permissions = Permissions.valueOf("READ")

  def main(args: Array[String]): Unit = {
    somePermission.openDocument

    println(somePermissionsOrdinal)
    println(allPermissions)
    println(readPermission)
  }

}
