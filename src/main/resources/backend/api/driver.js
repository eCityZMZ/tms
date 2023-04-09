function getMemberList (params) {
    return $axios({
        url: '/driver/page',
        method: 'get',
        params
    })
}

// 新增---添加驾驶员
function addDriver (params) {
    return $axios({
        url: '/driver',
        method: 'post',
        data: { ...params }
    })
}

// 修改---添加员工
function editDriver (params) {
    return $axios({
        url: '/driver',
        method: 'put',
        data: { ...params }
    })
}

// 修改页面反查详情接口
function queryDriverById (id) {
    return $axios({
        url: `/driver/${id}`,
        method: 'get'
    })
}

function exportDriverList(params){
    return $axios({
        url: '/driver/excel',
        method:'get',
        params:params,
        header: {
            headers: { 'Content-Type': 'application/x-download' }
        },
        responseType: 'blob'
    })
}