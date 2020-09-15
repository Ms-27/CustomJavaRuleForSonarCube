class MyClass {
  MyClass(MyClass mc) { }
  
  int     foo1() { return 0; }
  void    foo2(int value) { } // Noncompliant
  int     foo3(int zalue) { return 0; }
  Object  foo4(int value, String zalue) { return null; } // Noncompliant
  MyClass foo5(MyClass value) {return null; } // Noncompliant
  
  int     foo6(int zalue, String zame) { return 0; }
  int     foo7(int ... zalues) { return 0;}
}