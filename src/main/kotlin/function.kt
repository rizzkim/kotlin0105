//1부터 매개변수까지의 합계를 구해주는 함수
fun intSum(end:Int):Int{
    var tot=0
    for(i in 1..end){
        tot+=i
    }
    return tot
}
//2개의 숫자를 매개변수로 받아서 앞의 숫자부터 뒤의 숫자까지의 합꼐를 구해주는 함수
fun intSum(start:Int, end:Int):Int{
    var tot = 0
    for(i in start..end){
        tot+=i
    }
    return tot
}

//매개변수에 기본값 설정
//오버로딩이 된 경우 어떤 함수가 호출되는 것인지 혼란이 올 수 있습니다.
fun f(a:Int=10){
    println(a)
}
fun f(a:Int=10, b:Int=20){
    println(a)
    println(b)
}

fun main(){
    //함수의 이름은 같은데 매개변수의 개수나 자료형이 다르면 오버로딩
    println(intSum(100))
    println(intSum(1,50))

    //f 호출
    f(20)    //a에 20 대입
    f()         //a 에 기본값 10 대입

    //매개변수를 대입할 때 매개변수 이름과 함께 대입이 가능
    //매개변수의 대입 순서를 변경할 수 있고 함수 호출 구문이 읽기가 쉬워집니다.
    //되도록이면 이 방법을 사용해 호출하는 것을 권장합니다.
    //Apple Programming 에서는 이부분이 강제입니다.
    println(intSum(start=1, end=30))
    println(intSum(end=7, start=3))
}