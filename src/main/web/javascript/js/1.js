let user = {
    name: "张三",
    age: 20,
    sex: "男",
    run: function () {
        console.log(this.name + " running")
    }
}

let lisi = {
    name: "lisi"
}
lisi.__proto__=user

user.run()
lisi.run()
