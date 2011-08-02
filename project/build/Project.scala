import sbt._

class Project(info: ProjectInfo) extends DefaultProject(info) {
  val twitterRepo = "twitter.com" at "http://maven.twttr.com/"
  val jerksonRepo = "repo.codahale.com" at "http://repo.codahale.com"
  val finagle = "com.twitter" % "finagle" % "1.7.5"

  override def ivyXML =
    <dependencies>
      <exclude module="jms"/>
      <exclude module="jmxtools"/>
      <exclude module="jmxri"/>
    </dependencies>

  // specs2
  val specs2 = "org.specs2" %% "specs2" % "1.3"
  val scalaz = "org.specs2" %% "specs2-scalaz-core" % "6.0.RC2"

  def specs2Framework = new TestFramework("org.specs2.runner.SpecsFramework")
  override def testFrameworks = super.testFrameworks ++ Seq(specs2Framework)

  val snapshots = "snapshots" at "http://scala-tools.org/repo-snapshots"
  val releases  = "releases" at "http://scala-tools.org/repo-releases"

}

