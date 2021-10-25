package com.miloszjakubanis.thoughtseize.location

// import com.miloszjakubanis.thoughtseize.storage.{Storage, FileStorage}

// import java.io.File
// import java.nio.file.{Path, Paths}
// import java.nio.file.Files

// // object Location:


//   // def apply(name: String): Location = getLocationStrategy(name)

//   // def getLocationStrategy(name: String): Location =
//   //   val a = name.toLowerCase.nn.trim.nn
//   //     a match
//   //      case "docker" => DockerLocationStrategy
//   //      case "simple" => SimpleLocationStrategy
//   //      case _ => SimpleLocationStrategy

// trait Location(val folder: Path):

//   val root = Paths.get(System.getProperty("user.home").nn).nn

//   lazy val location: Path = root.resolve(folder).nn
//   lazy val storage: T 

//   private[this] def locationExists: Boolean = Files.exists(asPath)
//   private[this] def createLocationDir: Boolean = Files.createDirectories(asPath) != null