public class HelloWorld {
  public static int fibonacci(int n) {
    if (n <= 1) {
      return n;
    }
    return fibonacci(n - 1) + fibonacci(n - 2);
  }

  public static int fibonacci2(int n) {
    if (n <= 1) {
      return n;
    }

    int prev2 = 0, prev1 = 1;
    int result = 0;

    for (int i = 2; i <= n; i++) {
      result = prev1 + prev2;
      prev2 = prev1;
      prev1 = result;
    }

    return result;
  }

  public static void main(String[] var0) {
    System.out.println("Hello World!");
  }
}