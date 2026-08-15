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
// Post list changes
//


newData = new MyData()
newData.theFile = "SentenceDao.java"
newData.extMarker =
"""
  private String orderBy = "LAST_UPDATE DESC";
"""
newData.srcInsert =
"""
  private String orderBy = "_ID ASC";
"""
changes.add(newData)



newData = new MyData()
newData.theFile = "SentenceAdd.java"
newData.extMarker =
"""
    if (sentenceTextEdit.getText().toString().trim().length() > 0)
       sentence.setSentenceText(sentenceTextEdit.getText().toString());
    else
"""
newData.srcInsert =
"""
    if (sentenceTextEdit.getText().toString().trim().length() > 0) {
       String sentenceText = sentenceTextEdit.getText().toString() + ".";
       String sentenceTextCap = sentenceText.substring(0, 1).toUpperCase() + sentenceText.substring(1);
       sentence.setSentenceText(sentenceTextCap);
    } else
"""
changes.add(newData)



newData = new MyData()
newData.theFile = "sentence_add.xml"
newData.extMarker =
"""
            android:maxLength="255"
            android:inputType="textFilter"
            android:singleLine="true" />
"""
newData.srcInsert =
"""
            android:inputType="textMultiLine"
            android:maxLines="3" />
"""
changes.add(newData)



newData = new MyData()
newData.theFile = "activity.xml"
newData.extMarker =
"""
            android:drawableTop="@drawable/socialBook_help"
"""
newData.srcInsert =
"""
            android:drawableTop="@drawable/social_book_help"
"""
changes.add(newData)





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



//def strings = new File("./strings.xml").text
//new File("../booklet/app/src/main/res/values/strings.xml").write(strings)
