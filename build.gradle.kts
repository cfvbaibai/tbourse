allprojects {
    group = "cfvbaibai.tbourse"

    repositories {
        maven {
            url = java.net.URI("http://maven.aliyun.com/nexus/content/groups/public/")
        }
        maven {
            url = java.net.URI("http://maven.aliyun.com/nexus/content/repositories/jcenter")
        }
    }
}