import kotlin.properties.Delegates

class DTO{
    //get 만 생성 - 읽기 전용
    //get을 만들면 초기값을 부여하지 않아도 됩니다.
    val className:String
        get(){
            println("className에 접근")
            //초기값 부여
            return "DTO"
        }

    //get 과 set 모두 생성
    //var 은 반드시 초기값을 부여 해야 합니다.
    var num:Int = 0
        get(){
            println("num에 접근")
            return field
        }
        set(num:Int){
            if(num >= 100){
                println("num은 100보다 작거나 같아야 합니다.")
                field = 100
            }else {
                field = num
            }
        }
}

//Primary Constructor를 이용해서 초기화
class Initialize(var num : Int = 0){
    var name:String

    init{
        //초기화 블럭에서 프로퍼티를 초기화
        name="noname"
    }

    //나중에 초기화 - 기본 자료형은 안됨(숫자, Boolean, Char)
    lateinit var nickname:String

    //지연 생성 - 처음 사용할 때 메모리 할당을 하고 초기화를 수행
    val address:String by lazy{
        println("처음 사용할 때 생성됩니다")
        "서울시 양천구 목동"
    }

    //lateinit 과 by lazy는 선택적으로 생성되는 경우에 사용

    var x : String by Delegates.observable("default",
        {props, old, new -> println("${props}가 ${old}에서 ${new}로 변경")})
}

fun main(){
    var dto = DTO()
    //set 호출
    dto.num = 10000
    //get 호출
    println(dto.num)

    val initialize = Initialize()
    //lateinit이 붙은 프로퍼티 초기화
    initialize.nickname="보더"
    println("출력")
    //address는 by lazy가 붙었으므로 이렇게 처음 호출할 때 생성이 됩니다.
    println(initialize.nickname)
    println(initialize.address)
    println(initialize.name)

    initialize.x = "Hello"
    initialize.x = "Kotlin"
}