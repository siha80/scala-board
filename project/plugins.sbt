addSbtPlugin("me.lessis" % "bintray-sbt" % "0.3.0")

libraryDependencies <+= sbtVersion(v => "com.github.siasia" %% "xsbt-web-plugin" % (v+"-0.2.10"))