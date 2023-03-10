plugins{
    id("java")
    id("com.github.johnrengelman.shadow") version ("7.1.2")
    id("net.minecrell.plugin-yml.bukkit") version ("0.5.2")
}
group = "online.starsmc"
version = "no-shaded"

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(8))
}

bukkit {
    main = "$group.hubcore.Main"
    name = rootProject.name
    description = "HubCore pluging for 1.8 to 1.19"
    apiVersion = "1.13"
    version = "1.0.0"
    softDepend = listOf("PlaceholderAPI")
}

repositories {
    mavenCentral()
    maven("https://papermc.io/repo/repository/maven-public/")
    maven("https://repo.extendedclip.com/content/repositories/placeholderapi/")
    maven("https://repo.unnamed.team/repository/unnamed-public/")
    maven("https://s01.oss.sonatype.org/content/groups/public/")
}
dependencies {
    compileOnly("org.spigotmc:spigot-api:1.19.3-R0.1-SNAPSHOT")
    compileOnly("me.clip:placeholderapi:2.11.2")

    implementation("team.unnamed:inject:1.0.1")
    implementation("me.fixeddev:commandflow-bukkit:0.5.2")
}

tasks {
    shadowJar {
        archiveVersion.set("${bukkit.version}")
        archiveClassifier.set("")
    }
}
tasks {
    build {
        dependsOn("shadowJar")
    }
}