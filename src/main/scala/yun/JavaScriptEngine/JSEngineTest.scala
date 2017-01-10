package yun.JavaScriptEngine

import javax.script.{Invocable, ScriptEngineManager}

/**
  * Created by caiyunwu on 1/9/17.
  */
object JSEngineTest {
  def main(args: Array[String]): Unit = {
    val num=10
    val sem=new ScriptEngineManager()
    val engine=sem.getEngineByName("javascript")
    engine.eval("if(6>5){flag=true;}else{flag=flase}")
    println(engine.get("flag"))

    val jsFunction="function max(first,second){return (first>second)? true:false;}"
    engine.eval(jsFunction)
    val inv = engine.asInstanceOf[Invocable]
    val res=inv.invokeFunction("max",num.asInstanceOf[AnyRef],"1")
    println(res.asInstanceOf[Boolean])
  }
}
