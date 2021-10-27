import java.text.SimpleDateFormat
import java.util.Calendar

trait News
{
  def addPrefix(): Unit =
  {

  }
}

class SportNews(var text:String) extends News
{
  var prefix:String = ""
  override def addPrefix(): Unit =
  {
    val format = new SimpleDateFormat("d-M-y")
    val dateToday = format.format(Calendar.getInstance().getTime())
    this.text = dateToday + " " + this.text
  }
  override def toString = this.text
}

class CultureNews(var text:String) extends News
{
  val prefix:String = "!"
  override def addPrefix(): Unit =
  {
    this.text =   this.text + this.prefix
  }
  override def toString = this.text
}

object Main {
  def main(args: Array[String]) {
    var seq = Seq(
      new SportNews("S1"),
      new SportNews("S2"),
      new SportNews("S3"),
      new CultureNews("C1"),
      new CultureNews("C2"),
      new CultureNews("C3"),
    )
//    seq foreach println
    seq foreach(x=>x.addPrefix())
    seq foreach println
  }
}