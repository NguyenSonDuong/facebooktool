
$(document).ready((e)=>{
    console.log($("#id").val());
    let count = 0;
    let tableData = $("#tbMain").DataTable({
        processing: true,
        serverSide: true,
        deferLoading: 0,
        ajax: {
            url: "http://localhost:8080/api/v1/facebook-comment/comment/"+$("#id").val(),
            type:"GET",
            deferRender: true,
            dataSrc: ""
        },
        columns:[
            {
              data: null,
              className: "text-center",
              render: (data, type, row) => {
                  count++;
                  return count;
              }
            },
            {
                data:"author.name",
                className:"text-center",
                render: (data, type, row) =>{
                    return data;
                }
            },
            {
                data: "message",
                className:"",
                render: (data, type, row) =>{
                    return data;
                }
            },
            {
                data:"url",
                className:"text-center",
                render: (data, type, row) =>{
                    return `<a class="btn btn-success" href="${data}" target="_blank">Xem comment</a>`
                }
            },
            {
                data:"comment_created_time.seconds",
                className:"text-center",
                render: (data, type, row) =>{
                    return new Date(data*1000).toLocaleDateString();
                }
            }
        ]
    });
    console.log("XIn chào");
    tableData.ajax.reload();
})
