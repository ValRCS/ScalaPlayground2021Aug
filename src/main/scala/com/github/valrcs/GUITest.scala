package com.github.valrcs

object GUITest extends App {
  import scala.swing._

  new Frame {
    title = "Hello world"

    contents = new FlowPanel {
      contents += new Label("Launch rainbows:")
      contents += new Button("Click me") {
        reactions += {
          case event.ButtonClicked(_) =>
            println("All the colours!")
          case event.MouseEntered(e,x,y) =>
            println("Mouse entered button",e,x,y)

        }
      }
    }

    pack()
    centerOnScreen()
    open()
  }
}
