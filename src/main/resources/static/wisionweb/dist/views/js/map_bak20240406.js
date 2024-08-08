//------------------------------------------------------------配置项start

//边框线颜色、填充颜色
var m_strokeColor = "#80d8ff", m_fillColor = '#00b0ff', m_oldfillColor = '#00b0ff';
//边框线透明度、边框线宽、填充透明度
var m_strokeOpacity = 0.8, m_strokeWeight=1, m_fillOpacity = 0.8;
var textStyle = {
    'padding': '.5rem .5rem',
    'border-radius': '.25rem',
    'background-color': 'white',
    'border-width': 0,
    'text-align': 'center',
    'font-size': '12px',
    'color': 'blue'
};
//------------------------------------------------------------配置项end

/**
 * 绘制园
 * @param {中心点坐标：[137.00001, 34.00002]} centerPoint 
 * @param {半径} radius 
 */
function addCircle(centerPoint, radius, ltext) {
    var circle = new AMap.Circle({
        map: map,
        center: centerPoint,          //设置线覆盖物路径
        radius: radius,
        strokeColor: m_strokeColor, //边框线颜色
        strokeOpacity: m_strokeOpacity,       //边框线透明度
        strokeWeight: m_strokeWeight,        //边框线宽
        fillColor: m_oldfillColor, //填充色
        fillOpacity: m_fillOpacity,//填充透明度
        draggable: true
    });
    var text = new AMap.Text({
        text: ltext,
        anchor: 'top-left',//'center', // 设置文本标记锚点
        draggable: true,
        cursor: 'pointer',
        style: textStyle,
        position: currRightClickObjectPosition
    });

    overlays.push(circle);
    var contextMenu = loadMenu(0, circle, text);
    circle.on('rightclick', function (e) {
        contextMenu.open(map, e.lnglat);
        currRightClickObjectPosition = e.lnglat;
    });
    map.setDefaultCursor("pointer");
}
/**
 * 
 * @param {多边形坐标} polygonArr 
 */
function addPolygon(polygonArr) {
    var polygon = new AMap.Polygon({
        map: map,
        path: polygonArr,//设置多边形边界路径
        strokeColor: m_strokeColor, //线颜色
        strokeOpacity: m_strokeOpacity, //线透明度
        strokeWeight: m_strokeWeight,    //线宽
        fillColor: m_oldfillColor, //填充色
        fillOpacity: m_fillOpacity,//填充透明度
        draggable: true
    });
    var text = new AMap.Text({
        text: ltext,
        anchor: 'top-left',//'center', // 设置文本标记锚点
        draggable: true,
        cursor: 'pointer',
        style: textStyle,
        position: currRightClickObjectPosition
    });
    overlays.push(polygon);
    var contextMenu = loadMenu(0, polygon, text);
    polygon.on('rightclick', function (e) {
        contextMenu.open(map, e.lnglat);
        currRightClickObjectPosition = e.lnglat;
    });
    map.setDefaultCursor("pointer");
}
/**
 * 添加矩形
 * @param {西南坐标} wspoint 
 * @param {东北坐标} enpoint 
 */
function addRectangle(wspoint, enpoint, ltext) {
    var bounds = AMap.Bounds({southWest:wspoint, northEast:enpoint});
    var polygon = new AMap.Rectangle({
        bounds: bounds,
        strokeColor: m_strokeWeight,
        strokeWeight: m_strokeWeight,
        strokeOpacity: m_strokeOpacity,        
        strokeStyle: 'solid',
        fillColor: m_oldfillColor,
        fillOpacity: m_fillOpacity
    });
    var text = new AMap.Text({
        text: ltext,
        anchor: 'top-left',//'center', // 设置文本标记锚点
        draggable: true,
        cursor: 'pointer',
        style: textStyle,
        position: currRightClickObjectPosition
    });
    overlays.push(polygon);
    var contextMenu = loadMenu(0, polygon,text);
    polygon.on('rightclick', function (e) {
        contextMenu.open(map, e.lnglat);
        currRightClickObjectPosition = e.lnglat;
    });
    map.setDefaultCursor("pointer");
}
/**
 * 添加厂区
 * @param {西南坐标} wspoint 
 * @param {东北坐标} enpoint 
 */
function addChang(wspoint, enpoint) {
    //var bounds = new AMap.Bounds(new AMap.LngLat(118.055005,24.435624), new AMap.LngLat(118.078351,24.454299));
    var bounds = AMap.Bounds({southWest:wspoint, northEast:enpoint});
    var polygon = new AMap.Rectangle({
        bounds: bounds,
        strokeColor: m_strokeWeight,
        strokeWeight: m_strokeWeight,
        strokeOpacity: m_strokeOpacity,
        fillColor: m_oldfillColor,
        fillOpacity: m_fillOpacity
    });
    var imageLayer = new AMap.ImageLayer({
        url: 'http://amappc.cn-hangzhou.oss-pub.aliyun-inc.com/lbs/static/img/dongwuyuan.jpg',
        bounds: obj.getBounds(),
        zooms: [12, 18],
        opacity: 0.9,
        map: map,
        zIndex: 100
    });
    overlays.push(polygon);
    var contextMenu = loadMenu(0, polygon, imageLayer);
    polygon.on('rightclick', function (e) {
        contextMenu.open(map, e.lnglat);
        currRightClickObjectPosition = e.lnglat;
    });
    map.setDefaultCursor("pointer");
}


//初始化图层
// var map = new AMap.Map('container', {
//     resizeEnable: true, //是否监控地图容器尺寸变化
//     zoom: 17, //初始化地图层级
//     center: default_lnglat //初始化地图中心点
// });


//---------------------------------------------------------------------------------------------------------以下是自动化绘制
//当前右击选择的对象，不用配置
var currRightClickObject = null;
var currRightClickObjectPosition = null;
var drawType = null;

function loadMenu(type, obj, ptext) {
    //创建右键菜单
    var contextMenu = new AMap.ContextMenu();

    switch (type) {
        case 1:
            //选择区域
            contextMenu.addItem("编辑需求", function () {
                console.log(obj);
                console.log(currRightClickObjectPosition);
                // TODO....................................................选择区域的弹窗等
                // 选择区域完成
                {
                    var text = new AMap.Text({
                        text: '我是谁',
                        anchor: 'top-left',//'center', // 设置文本标记锚点
                        draggable: true,
                        cursor: 'pointer',
                        style: textStyle,
                        position: currRightClickObjectPosition
                    });
                    text.setMap(map);
                    obj.setOptions({ fillColor: m_fillColor });
                    obj.off('rightclick');
                    var contextMenu = loadMenu(0, obj, text);
                    obj.on('rightclick', function (e) {
                        contextMenu.open(map, e.lnglat);
                    });

                    // 创建信息窗体对象
                    var infoWindow = new AMap.InfoWindow({
                        content: '123',
                        offset: new AMap.Pixel(0, -30)
                    });
                    // 点击地图时弹出信息窗体
                    map.on('rightclick', function(e) {
                        infoWindow.open(map, e.lnglat);
                    });
                }
            }, 0);
            break;
        case 2:
            //“上传厂区楼层图”
            contextMenu.addItem("上传厂区楼层图", function () {//
                
                // TODO....................................................选择厂区的弹窗等
                // 选择厂区完成
                var imageLayer = new AMap.ImageLayer({
                    url: 'http://amappc.cn-hangzhou.oss-pub.aliyun-inc.com/lbs/static/img/dongwuyuan.jpg',
                    bounds: obj.getBounds(),
                    zooms: [12, 18],
                    opacity: 0.9,
                    map: map,
                    zIndex: 100
                });

                obj.off('rightclick');
                var contextMenu = loadMenu(0, obj, imageLayer);
                obj.on('rightclick', function (e) {
                    contextMenu.open(map, e.lnglat);
                });

                obj.setOptions({strokeOpacity:0,fillOpacity:0})
                // obj.setMap(null);
                // overlays.pop(obj);        
            }, 0);
            break;
    }

    //删除
    contextMenu.addItem("删除", function () {
        obj.setMap(null);
        if (ptext != null) {
            ptext.setMap(null);
        }
        overlays.pop(obj);

        console.log(obj);
    }, 1);
    return contextMenu;
}

var mouseTool = new AMap.MouseTool(map);
//监听draw事件可获取画好的覆盖物
var overlays = [];
mouseTool.on('draw', function (e) {
    overlays.push(e.obj);
    currRightClickObject = e.obj;
    //地图绑定鼠标右击事件——弹出右键菜单
    var type = 0;
    if (drawType == "chang") {
        type = 2;
    } else {
        type = 1;
    }
    var contextMenu = loadMenu(type, e.obj);

    e.obj.on('rightclick', function (e) {
        contextMenu.open(map, e.lnglat);
        currRightClickObjectPosition = e.lnglat;
    });
    map.setDefaultCursor("pointer");
    mouseTool.close();
})

function drawObj(type) {
    switch (type) {
        case 'marker': {
            mouseTool.marker({
                //同Marker的Option设置
            });
            break;
        }
        case 'polyline': {
            mouseTool.polyline({
                strokeColor: '#80d8ff'
                //同Polyline的Option设置
            });
            break;
        }
        case 'polygon': {
            mouseTool.polygon({
                fillColor: '#00b0ff',
                strokeColor: '#80d8ff'
                //同Polygon的Option设置
            });
            break;
        }
        case 'rectangle': {
            mouseTool.rectangle({
                fillColor: '#00b0ff',
                strokeColor: '#80d8ff'
                //同Polygon的Option设置
            });
            break;
        }
        case 'circle': {
            mouseTool.circle({
                fillColor: '#00b0ff',
                strokeColor: '#80d8ff'
                //同Circle的Option设置
            });
            break;
        }
        case 'chang': {
            mouseTool.rectangle({
                fillColor: '#00b0ff',
                strokeColor: '#80d8ff',
                strokeStyle: 'dashed'
            });
            break;
        }
    }
    //使用CSS默认样式定义地图上的鼠标样式
    map.setDefaultCursor("crosshair");
    drawType = type;
}

// 事件绑定
function clickOn() {
    log.success("绑定事件!");
    map.on('click', showInfoClick);
    //map.on('dblclick', showInfoDbClick);
    //map.on('mousemove', showInfoMove);
}
// 解绑事件
function clickOff() {
    log.success("解除事件绑定!");
    map.off('click', showInfoClick);
    //map.off('dblclick', showInfoDbClick);
    //map.off('mousemove', showInfoMove);
}

function load() {
    // addMarker();
}