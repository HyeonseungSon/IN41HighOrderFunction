/*
High Order Function
 - 매개변수를 함수나 Lambda 로 받거나
  반환값을 함수 또는 Lambda 로 돌려주는 함수
 */
fun main() {

    val t1 = fun(x1:Int, x2:Int) : Int {
        return x1 + x2
    }

    testFunc1(t1, 100, 200)

    testFunc1(fun (x1:Int, x2:Int) : Int {
        return x1 - x2
    }, 100, 200)

    val lambda1 = {x1:Int, x2:Int -> x1 * x2}
    testFunc1(lambda1, 100, 200)
    testFunc1({x1:Int, x2:Int -> x1 / x2}, 200, 100)

    val t2 = testFunc2() // t2 에는 testFun2 의 return 값인 익명함수가 들어갑니다.
    val r2 = t2 (100, 200)
    println("r2 : $r2")

    val t3 = testFunc3() // t3 에는 Lambda 가 들어갑니다.
    val r3 = t3 (100, 200)
    println("r3 : $r3")

    testFunc4({x1:Int -> x1 + 100}, 200)
    // 고차함수에 정의되어있는 매개변수인 함수의 매개변수가 한 개인 경우에는 it 사용 가능
    testFunc4({it + 100}, 200)

    testFunc5(100, 200, {x1:Int, x2:Int -> x1 + x2})
    // 함수의 매개변수 값 입력하는 괄호 외부에 Lambda 를 입력하는 기능도 제공 (Lambda 식이 장문일 경우 대비)
    testFunc5(100, 200) {x1:Int, x2:Int -> x1 + x2}

    testFunc6({x1:Int -> println(x1)})

    testFunc6{println(it)}
}

fun testFunc1(m1:(Int, Int) -> Int, a1:Int, a2:Int){
    val r1 = m1(a1, a2)
    println("r1 : $r1")
}

// 반환값이 함수인 함수
fun testFunc2 () : (Int, Int) -> Int {

    return fun (x1:Int, x2:Int) : Int {
        return x1 + x2
    }
}

// 반환값이 Lambda 인 함수
fun testFunc3 () : (Int, Int) -> Int {
    return {x1:Int, x2:Int -> x1 - x2}
}

fun testFunc4 (m1:(Int) -> Int, a1:Int) { // 함수 한 개, 정수 한 개
    val r4 = m1 (a1)
    println("r4 : $r4")
}

fun testFunc5 (a1:Int, a2: Int, m1: (Int, Int) -> Int) {

    val r5 = m1 (a1, a2)
    println("r5 : $r5")
}

fun testFunc6(m1:(Int) -> Unit){
    m1(100)
}