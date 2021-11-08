
// $.get("/user", function(data) {
//     $("#usuario").html(data.name)
//     $(".sin-autenticar").hide()
//     $(".autenticado").show()
// })



$.ajax({
    url: "/user",
    type: "GET",
    success: function(response) {
        $("#usuario").html(response.name)
        $(".sin-autenticar").hide()
        $(".autenticado").show()
    }
})
