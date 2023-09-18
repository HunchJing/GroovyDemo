static void main(String[] args) {
  def list = new ArrayList<String>()
  def stringList = new ListType<String>()
  def integerList = new ListType<Integer>()
  list.add("First String")
  list.add("Second String")
  stringList.setLocalt("liujing's test")
  integerList.setLocalt(123)
  println list
  println(stringList.getLocalt())
  println(integerList.getLocalt())
}

class ListType<T>{

  private T localt;

  T getLocalt() {
    return localt
  }

  void setLocalt(T localt) {
    this.localt = localt
  }
}