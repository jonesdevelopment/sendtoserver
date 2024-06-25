import net.minecrell.pluginyml.bukkit.BukkitPluginDescription

plugins {
  java
  id("io.github.goooler.shadow") version "8.1.7" apply true
  id("net.minecrell.plugin-yml.bukkit") version "0.6.0" apply true
}

bukkit {
  name = "send2server"
  description = rootProject.description
  version = rootProject.version.toString()
  main = "xyz.jonesdev.s2s.bukkit.S2SBukkitPlugin"
  authors = listOf("Jones Development")
  website = "https://jonesdev.xyz/discord/"
  load = BukkitPluginDescription.PluginLoadOrder.POSTWORLD
  foliaSupported = true

  commands {
    register("s2s") {
      aliases = listOf("send2server", "sendtoserver")
      permission = "send2server.command"
    }
  }
}

tasks {
  shadowJar {
    minimize()
  }

  jar {
    manifest {
      attributes["Implementation-Title"] = rootProject.name
      attributes["Implementation-Version"] = rootProject.version
      attributes["Implementation-Vendor"] = "Jones Development"
    }
  }

  compileJava {
    options.encoding = "UTF-8"
  }
}

repositories {
  mavenCentral()
  maven(url = "https://hub.spigotmc.org/nexus/content/repositories/snapshots/") // Spigot
  maven(url = "https://oss.sonatype.org/content/repositories/snapshots/") // BungeeCord Chat API
}

dependencies {
  compileOnly("org.spigotmc:spigot-api:1.8.8-R0.1-SNAPSHOT")
}

java.sourceCompatibility = JavaVersion.VERSION_1_8
java.targetCompatibility = JavaVersion.VERSION_1_8
