def changes = []

public class MyData {

  def theFile = ""

  def extMarker =
"""
"""
  def srcInsert =
"""
"""
}
MyData newData = new MyData()



//
// Sync file change
// 
def dir = "../booklet"

def extFiles ( theDir, changes ) {

   def fileList = new File(theDir).list().toList()

   for ( i in fileList ) {

      def inFile = theDir + "/" + i
      def f1= new File(inFile)

      MyData myData = new MyData();

      if ( f1.isDirectory() ) {
         extFiles ( inFile, changes )
      } else {
//println(i)
        for (c in changes) {
          MyData theData = c
          if ( i.equals(theData.theFile) ) {
            def oldFile = new File(inFile).text
            def newMarker = theData.extMarker.replaceAll( "\\\n", "\\\r\\\n" )
            def newSrc = theData.srcInsert.replaceAll( "\\\n", "\\\r\\\n" )
            def newFile = oldFile.replace(newMarker, newSrc)
            new File(inFile).write(newFile)
            if (newFile.contains(newSrc) == false) { println(theData.theFile + " missing changes") }
          }

        }

      } 
   }
}

extFiles ( dir, changes )

def src = new File("./logo.png").newDataInputStream()
def dst = new File("../booklet/app/src/main/res/drawable/logo.png").newDataOutputStream()
dst << src

def src1 = new File("./hdpi-logo.png").newDataInputStream()
def dst1 = new File("../booklet/app/src/main/res/drawable-hdpi/logo.png").newDataOutputStream()
dst1 << src1

def src2 = new File("./ldpi-logo.png").newDataInputStream()
def dst2 = new File("../booklet/app/src/main/res/drawable-ldpi/logo.png").newDataOutputStream()
dst2 << src2

def src3 = new File("./mdpi-logo.png").newDataInputStream()
def dst3 = new File("../booklet/app/src/main/res/drawable-mdpi/logo.png").newDataOutputStream()
dst3 << src3

def src4 = new File("./xhdpi-logo.png").newDataInputStream()
def dst4 = new File("../booklet/app/src/main/res/drawable-xhdpi/logo.png").newDataOutputStream()
dst4 << src4

def src5 = new File("./xxhdpi-logo.png").newDataInputStream()
def dst5 = new File("../booklet/app/src/main/res/drawable-xxhdpi/logo.png").newDataOutputStream()
dst5 << src5
