class Student {
    constructor(name) {
        this.name = name
    }
    hello(){
        console.log('hello')
    }
}

class pupil extends Student{
    constructor(name,grade) {
        super(name)
        this.grade=grade
    }

    myGrade(){
        console.log("我是小学生"+this.name)
    }

}

let jack=new Student("jack")
let tom=new pupil("tom",3)
jack.hello()
tom.hello()
tom.myGrade()