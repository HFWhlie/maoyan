package com.atguigu.maoyan.bean;

import java.util.List;

/**
 * Created by tao on 2016/6/28.
 */
public class Citybean {

    /**
     * expires : 43200
     */

    private ControlBean control;
    /**
     * control : {"expires":43200}
     * status : 0
     * data : {"chaoyang":[{"addr":"chaoyang京顺路111号比如世界购物中心1层（近太阳宫北街）","nm":"17.5影城(比如世界店)","ct":"","deal":0,"dis":"望京","brd":"17.5影城","distance":0,"follow":0,"imax":0,"sellPrice":22,"poiId":75603,"lat":39.9684,"lng":116.46204,"sell":true,"sellmin":0,"preferential":0,"area":"chaoyang","brdId":23854,"dealPrice":0,"referencePrice":70,"showCount":0,"id":48},{"addr":"chaoyang朝阳路京通苑30号楼L307PLus365购物中心三层","nm":"17.5影城(管庄店)","ct":"","deal":0,"dis":"管庄","brd":"17.5影城","distance":0,"follow":0,"imax":0,"sellPrice":22,"poiId":1677952,"lat":39.912422,"lng":116.596085,"sell":true,"sellmin":0,"preferential":0,"area":"chaoyang","brdId":23854,"dealPrice":0,"referencePrice":60,"showCount":0,"id":2243},{"addr":"chaoyang湖景东路11号新奥购物中心B1-B2楼","nm":"CGV星聚汇星星影城(奥体店)","ct":"","deal":0,"dis":"亚运村","brd":"CGV星聚汇影城","distance":0,"follow":0,"imax":0,"sellPrice":57,"poiId":360511,"lat":39.999462,"lng":116.39392,"sell":true,"sellmin":0,"preferential":0,"area":"chaoyang","brdId":2020418,"dealPrice":0,"referencePrice":40,"showCount":0,"id":65},{"addr":"chaoyang酒仙桥路18号颐堤港4层","nm":"CGV星聚汇星星影城(颐堤港店)","ct":"","deal":0,"dis":"酒仙桥","brd":"CGV星聚汇影城","distance":0,"follow":0,"imax":0,"sellPrice":57,"poiId":1466992,"lat":39.96964,"lng":116.4909,"sell":true,"sellmin":0,"preferential":0,"area":"chaoyang","brdId":2020418,"dealPrice":0,"referencePrice":40,"showCount":0,"id":8},{"addr":"chaoyang北苑路42号卜峰莲花超市4楼（K酷时尚广场）","nm":"K酷国际影城","ct":"","deal":1,"dis":"亚运村","brd":"K酷国际影城","distance":0,"follow":0,"imax":0,"sellPrice":38,"poiId":796845,"lat":40.033382,"lng":116.41916,"sell":true,"sellmin":0,"preferential":0,"area":"chaoyang","brdId":24003,"dealPrice":35.5,"referencePrice":80,"showCount":0,"id":21},{"addr":"chaoyang东三环中路65号富力广场6楼（双井桥北）","nm":"UME国际影城(双井店)","ct":"","deal":0,"dis":"双井","brd":"UME国际影城","distance":0,"follow":0,"imax":0,"sellPrice":39.5,"poiId":291070,"lat":39.89768,"lng":116.45983,"sell":true,"sellmin":0,"preferential":0,"area":"chaoyang","brdId":24071,"dealPrice":0,"referencePrice":70,"showCount":0,"id":135},{"addr":"chaoyang工体北路13号世茂工三3楼，艾米·1895电影街（三里屯商圈）","nm":"艾米·1895电影街","ct":"","deal":1,"dis":"","brd":"其它","distance":0,"follow":0,"imax":0,"sellPrice":53,"poiId":42853106,"lat":39.93605,"lng":116.44939,"sell":true,"sellmin":0,"preferential":0,"area":"chaoyang","brdId":0,"dealPrice":100,"referencePrice":0,"showCount":0,"id":13640},{"addr":"chaoyang清河营南街7号院华贸天地B1楼","nm":"保利国际影城(北苑华贸店)","ct":"","deal":0,"dis":"北苑","brd":"保利国际影城","distance":0,"follow":0,"imax":0,"sellPrice":39,"poiId":361205,"lat":40.047962,"lng":116.43101,"sell":true,"sellmin":0,"preferential":0,"area":"chaoyang","brdId":24472,"dealPrice":0,"referencePrice":25,"showCount":0,"id":2603},{"addr":"chaoyang东坝中路38号金隅嘉品MALL5层","nm":"保利国际影城(东坝店)","ct":"","deal":0,"dis":"","brd":"保利国际影城","distance":0,"follow":0,"imax":0,"sellPrice":29,"poiId":73452594,"lat":39.951107,"lng":116.54848,"sell":true,"sellmin":0,"preferential":0,"area":"chaoyang","brdId":24472,"dealPrice":0,"referencePrice":0,"showCount":0,"id":14430},{"addr":"chaoyang望京阜通西大街新荟城购物中心五层","nm":"保利国际影城(望京店)","ct":"","deal":0,"dis":"望京","brd":"保利国际影城","distance":0,"follow":0,"imax":0,"sellPrice":39,"poiId":1107541,"lat":39.998497,"lng":116.481926,"sell":true,"sellmin":0,"preferential":0,"area":"chaoyang","brdId":24472,"dealPrice":0,"referencePrice":70,"showCount":0,"id":39},{"addr":"chaoyang北辰东路5号（鸟巢正北一公里）","nm":"保利国际影城(中国科技馆店)","ct":"","deal":0,"dis":"亚运村","brd":"保利国际影城","distance":0,"follow":0,"imax":0,"sellPrice":29,"poiId":61574,"lat":40.005745,"lng":116.39992,"sell":true,"sellmin":0,"preferential":0,"area":"chaoyang","brdId":24472,"dealPrice":0,"referencePrice":80,"showCount":0,"id":40},{"addr":"chaoyang建国门外大街1号国贸商城区域三地下一层3B120","nm":"百丽宫影城(国贸店)","ct":"","deal":0,"dis":"国贸","brd":"百老汇影城","distance":0,"follow":0,"imax":0,"sellPrice":68,"poiId":3281398,"lat":39.91279,"lng":116.45982,"sell":true,"sellmin":0,"preferential":0,"area":"chaoyang","brdId":24377,"dealPrice":0,"referencePrice":90,"showCount":0,"id":23},{"addr":"chaoyang三丰北里2号楼悠唐生活广场B1楼（近钱柜）","nm":"博纳国际影城(悠唐店)","ct":"","deal":0,"dis":"朝外大街","brd":"博纳国际影城","distance":0,"follow":0,"imax":1,"sellPrice":44,"poiId":63,"lat":39.922,"lng":116.44,"sell":true,"sellmin":0,"preferential":0,"area":"chaoyang","brdId":24595,"dealPrice":0,"referencePrice":35,"showCount":0,"id":116},{"addr":"chaoyang朝阳公园路6号蓝色港湾国际商区SA-42（朝阳公园西北角）","nm":"传奇时代影城(蓝色港湾店)","ct":"","deal":0,"dis":"亮马桥","brd":"传奇时代影城","distance":0,"follow":0,"imax":0,"sellPrice":39.5,"poiId":297916,"lat":39.949085,"lng":116.47616,"sell":true,"sellmin":0,"preferential":0,"area":"chaoyang","brdId":24804,"dealPrice":0,"referencePrice":40,"showCount":0,"id":132},{"addr":"chaoyang曙光西里甲5号院24号楼凤凰汇三层","nm":"橙天嘉禾影城(凤凰城店)","ct":"","deal":0,"dis":"三元桥","brd":"橙天嘉禾影城","distance":0,"follow":0,"imax":0,"sellPrice":33.5,"poiId":1465641,"lat":39.962627,"lng":116.45721,"sell":true,"sellmin":0,"preferential":0,"area":"chaoyang","brdId":24745,"dealPrice":0,"referencePrice":80,"showCount":0,"id":2081},{"addr":"chaoyang东三环北路36号呼家楼北（近朝阳北路）","nm":"朝阳剧场","ct":"","deal":1,"dis":"亮马桥","brd":"朝阳剧场","distance":0,"follow":0,"imax":0,"sellPrice":33,"poiId":82595,"lat":39.922314,"lng":116.462105,"sell":true,"sellmin":0,"preferential":0,"area":"chaoyang","brdId":635050,"dealPrice":36,"referencePrice":60,"showCount":0,"id":249},{"addr":"chaoyang望京阜安西街11号楼合生麒麟新天地2层","nm":"大地数字影院(望京新天地店)","ct":"","deal":1,"dis":"","brd":"大地影院","distance":0,"follow":0,"imax":0,"sellPrice":38,"poiId":4036242,"lat":39.99817,"lng":116.47787,"sell":true,"sellmin":0,"preferential":0,"area":"chaoyang","brdId":384262,"dealPrice":40.5,"referencePrice":0,"showCount":0,"id":7881},{"addr":"chaoyang东四环中路195号华腾新天地五层","nm":"东都影城","ct":"","deal":0,"dis":"大望路","brd":"东都影城","distance":0,"follow":0,"imax":0,"sellPrice":43,"poiId":30903,"lat":39.885048,"lng":116.48847,"sell":true,"sellmin":0,"preferential":0,"area":"chaoyang","brdId":133085,"dealPrice":0,"referencePrice":43,"showCount":0,"id":262},{"addr":"chaoyang南杨庄路与武基街交叉口西南方向50米路南（垡头永辉超市，翠城馨园401号楼地下一层）","nm":"大地影院(垡头永辉店)","ct":"","deal":1,"dis":"","brd":"大地影院","distance":0,"follow":0,"imax":0,"sellPrice":33,"poiId":41877507,"lat":39.856857,"lng":116.50524,"sell":true,"sellmin":0,"preferential":0,"area":"chaoyang","brdId":384262,"dealPrice":40.5,"referencePrice":0,"showCount":0,"id":10954},{"addr":"chaoyang西大望南路与弘燕南一路交叉口铭泽生活广场5层","nm":"大地影院(十里河铭泽影院 )","ct":"","deal":1,"dis":"","brd":"大地影院","distance":0,"follow":0,"imax":0,"sellPrice":33,"poiId":40086376,"lat":39.864407,"lng":116.47688,"sell":true,"sellmin":0,"preferential":0,"area":"chaoyang","brdId":384262,"dealPrice":40.5,"referencePrice":0,"showCount":0,"id":10951},{"addr":"chaoyang祁家豁子8号健翔大厦家乐福超市B1层","nm":"海航文化天宝国际影城","ct":"","deal":1,"dis":"亚运村","brd":"其它","distance":0,"follow":0,"imax":0,"sellPrice":33,"poiId":1098864,"lat":39.98034,"lng":116.38147,"sell":true,"sellmin":0,"preferential":0,"area":"chaoyang","brdId":0,"dealPrice":39.6,"referencePrice":80,"showCount":0,"id":31},{"addr":"chaoyang七圣中街12号院爱琴海购物中心6层","nm":"红星太平洋电影城(爱琴海购物中心店)","ct":"","deal":0,"dis":"","brd":"太平洋电影城","distance":0,"follow":0,"imax":0,"sellPrice":53,"poiId":5948789,"lat":39.97224,"lng":116.436386,"sell":true,"sellmin":0,"preferential":0,"area":"chaoyang","brdId":28975,"dealPrice":0,"referencePrice":0,"showCount":0,"id":7619},{"addr":"chaoyang姚家园路甲1号活力东方奥特莱斯购物中心4楼","nm":"嘉华国际影城(活力东方店)","ct":"","deal":1,"dis":"","brd":"嘉华国际影城","distance":0,"follow":0,"imax":0,"sellPrice":39,"poiId":2578227,"lat":39.940395,"lng":116.52246,"sell":true,"sellmin":0,"preferential":0,"area":"chaoyang","brdId":26413,"dealPrice":30,"referencePrice":70,"showCount":0,"id":5987},{"addr":"chaoyang北三环东路22号","nm":"金鸡百花影城","ct":"","deal":0,"dis":"左家庄","brd":"金鸡百花影城","distance":0,"follow":0,"imax":0,"sellPrice":38,"poiId":89000,"lat":39.96894,"lng":116.42397,"sell":true,"sellmin":0,"preferential":0,"area":"chaoyang","brdId":1082447,"dealPrice":0,"referencePrice":30,"showCount":0,"id":256},{"addr":"chaoyang劲松中街404号","nm":"劲松电影院","ct":"","deal":0,"dis":"劲松","brd":"劲松电影院","distance":0,"follow":0,"imax":0,"sellPrice":33,"poiId":82588,"lat":39.88321,"lng":116.45597,"sell":true,"sellmin":0,"preferential":0,"area":"chaoyang","brdId":252281,"dealPrice":0,"referencePrice":30,"showCount":0,"id":236},{"addr":"chaoyang朝阳北路101号朝阳大悦城商场8层","nm":"金逸影城(朝阳大悦城IMAX店)","ct":"","deal":0,"dis":"十里堡","brd":"金逸影城","distance":0,"follow":0,"imax":1,"sellPrice":49,"poiId":1548100,"lat":39.924355,"lng":116.51871,"sell":true,"sellmin":0,"preferential":0,"area":"chaoyang","brdId":1079568,"dealPrice":0,"referencePrice":80,"showCount":0,"id":88},{"addr":"chaoyang双桥路3号东星时尚广场5层","nm":"金逸影城(双桥店)","ct":"","deal":0,"dis":"管庄","brd":"金逸影城","distance":0,"follow":0,"imax":0,"sellPrice":29,"poiId":1439570,"lat":39.90879,"lng":116.57644,"sell":true,"sellmin":0,"preferential":0,"area":"chaoyang","brdId":1079568,"dealPrice":0,"referencePrice":0,"showCount":0,"id":1692},{"addr":"chaoyang东大桥路9号侨福芳草地购物中心LG2-26（尚都SOHO对面）","nm":"卢米埃影城(芳草地店)","ct":"","deal":0,"dis":"","brd":"卢米埃影城","distance":0,"follow":0,"imax":0,"sellPrice":58,"poiId":332108,"lat":39.9192,"lng":116.4496,"sell":true,"sellmin":0,"preferential":0,"area":"chaoyang","brdId":292030,"dealPrice":0,"referencePrice":50,"showCount":0,"id":5736},{"addr":"chaoyang朝阳北路长楹天街购物中心东区5F-09","nm":"卢米埃影城(长楹天街IMAX店)","ct":"","deal":0,"dis":"","brd":"卢米埃影城","distance":0,"follow":0,"imax":1,"sellPrice":43,"poiId":52539636,"lat":39.92509,"lng":116.60262,"sell":true,"sellmin":0,"preferential":0,"area":"chaoyang","brdId":292030,"dealPrice":0,"referencePrice":0,"showCount":0,"id":13204},{"addr":"chaoyang立清路明天第一城7号院，蓝黛时空汇内","nm":"鲁信影城(立水桥店)","ct":"","deal":1,"dis":"北苑家园","brd":"鲁信影城","distance":0,"follow":0,"imax":0,"sellPrice":33,"poiId":1541423,"lat":40.04711,"lng":116.4083,"sell":true,"sellmin":0,"preferential":0,"area":"chaoyang","brdId":27424,"dealPrice":25,"referencePrice":70,"showCount":0,"id":1732},{"addr":"chaoyang三里屯太古里地下一层（三里屯酒吧街南口西侧）","nm":"美嘉欢乐影城(三里屯店)","ct":"","deal":0,"dis":"三里屯","brd":"美嘉欢乐影城","distance":0,"follow":0,"imax":0,"sellPrice":49,"poiId":30915,"lat":39.934406,"lng":116.45507,"sell":true,"sellmin":0,"preferential":0,"area":"chaoyang","brdId":27617,"dealPrice":0,"referencePrice":80,"showCount":0,"id":136},{"addr":"chaoyang建国路93号万达广场B座3层","nm":"万达国际影城(CBD店)","ct":"","deal":0,"dis":"大望路","brd":"万达影城","distance":0,"follow":0,"imax":1,"sellPrice":43,"poiId":30863,"lat":39.909027,"lng":116.4709,"sell":true,"sellmin":0,"preferential":0,"area":"chaoyang","brdId":102642,"dealPrice":0,"referencePrice":80,"showCount":0,"id":264},{"addr":"chaoyang朝阳北路17号（地铁6号线常营站B出口）北京华联购物中心四层","nm":"沃美影城(常营店)","ct":"","deal":0,"dis":"","brd":"沃美影城","distance":0,"follow":0,"imax":0,"sellPrice":43,"poiId":5529977,"lat":39.926224,"lng":116.598885,"sell":true,"sellmin":0,"preferential":0,"area":"chaoyang","brdId":29462,"dealPrice":0,"referencePrice":0,"showCount":0,"id":8065},{"addr":"chaoyang立汤路201号东亚奥北南区北门一楼（华泰汽车斜对面，立水桥地铁A口北行150米）","nm":"星环影城(立水桥店)","ct":"","deal":1,"dis":"","brd":"其它","distance":0,"follow":0,"imax":0,"sellPrice":38,"poiId":3260787,"lat":40.05452,"lng":116.41205,"sell":true,"sellmin":0,"preferential":0,"area":"chaoyang","brdId":0,"dealPrice":25,"referencePrice":60,"showCount":0,"id":9914},{"addr":"chaoyang金汇路8号世界城E座B1楼（世贸天阶商业街北侧）","nm":"星美国际影城(世界城店)","ct":"","deal":0,"dis":"朝外大街","brd":"星美国际影城","distance":0,"follow":0,"imax":0,"sellPrice":9,"poiId":316112,"lat":39.917755,"lng":116.45232,"sell":true,"sellmin":0,"preferential":0,"area":"chaoyang","brdId":30032,"dealPrice":0,"referencePrice":35,"showCount":0,"id":98},{"addr":"chaoyang望京街9号望京国际商业中心A座4楼","nm":"星美国际影城(望京店)","ct":"","deal":0,"dis":"望京","brd":"星美国际影城","distance":0,"follow":0,"imax":0,"sellPrice":44,"poiId":1558123,"lat":39.990322,"lng":116.48359,"sell":true,"sellmin":0,"preferential":0,"area":"chaoyang","brdId":30032,"dealPrice":0,"referencePrice":40,"showCount":0,"id":175},{"addr":"chaoyang广顺北大街16号望京华彩商业中心B1a","nm":"新影联·华谊兄弟影院(望京店)","ct":"","deal":1,"dis":"望京","brd":"华谊兄弟影院","distance":0,"follow":0,"imax":0,"sellPrice":44,"poiId":82583,"lat":40.01051,"lng":116.46821,"sell":true,"sellmin":0,"preferential":0,"area":"chaoyang","brdId":275830,"dealPrice":35,"referencePrice":80,"showCount":0,"id":72},{"addr":"chaoyang安立路68号飘亮广场B1层","nm":"阳光影城(安立路店)","ct":"","deal":1,"dis":"亚运村","brd":"阳光影城","distance":0,"follow":0,"imax":0,"sellPrice":38,"poiId":90846,"lat":39.997986,"lng":116.409164,"sell":true,"sellmin":0,"preferential":0,"area":"chaoyang","brdId":30206,"dealPrice":28,"referencePrice":70,"showCount":0,"id":174},{"addr":"chaoyang慈云寺北里209号未来汇二层","nm":"耀莱成龙国际影城(慈云寺店)","ct":"","deal":1,"dis":"","brd":"耀莱成龙国际影城","distance":0,"follow":0,"imax":0,"sellPrice":38,"poiId":4230363,"lat":39.916035,"lng":116.4922,"sell":true,"sellmin":0,"preferential":0,"area":"chaoyang","brdId":30227,"dealPrice":35,"referencePrice":0,"showCount":0,"id":9730},{"addr":"chaoyang安华西里甲1号","nm":"中国木偶艺术剧院","ct":"","deal":1,"dis":"安贞","brd":"其它","distance":0,"follow":0,"imax":0,"sellPrice":23,"poiId":82596,"lat":39.96802,"lng":116.40147,"sell":true,"sellmin":0,"preferential":0,"area":"chaoyang","brdId":0,"dealPrice":31,"referencePrice":0,"showCount":0,"id":252},{"addr":"chaoyang朝外大街8号（蓝岛大厦西区5-6层）","nm":"紫光影城(蓝岛店)","ct":"","deal":1,"dis":"朝外大街","brd":"紫光影城","distance":0,"follow":0,"imax":0,"sellPrice":33,"poiId":3274641,"lat":39.922623,"lng":116.44817,"sell":true,"sellmin":0,"preferential":0,"area":"chaoyang","brdId":31014,"dealPrice":21,"referencePrice":35,"showCount":0,"id":259},{"addr":"chaoyang西直河商业广场华联购物广场1楼","nm":"北京东融国际影城","ct":"","deal":0,"dis":"","brd":"其它","distance":0,"follow":0,"imax":0,"sellPrice":0,"poiId":91811925,"lat":39.844444,"lng":116.52732,"sell":false,"sellmin":0,"preferential":0,"area":"chaoyang","brdId":0,"dealPrice":0,"referencePrice":0,"showCount":0,"id":15415},{"addr":"chaoyang安慧里三区10号","nm":"北京剧院","ct":"","deal":0,"dis":"亚运村","brd":"北京剧院","distance":0,"follow":0,"imax":0,"sellPrice":38,"poiId":82597,"lat":39.990856,"lng":116.40813,"sell":false,"sellmin":0,"preferential":0,"area":"chaoyang","brdId":254168,"dealPrice":0,"referencePrice":80,"showCount":0,"id":248},{"addr":"chaoyang亮马桥路21号（朝阳公园北门对面）","nm":"枫花园汽车影院","ct":"","deal":0,"dis":"亮马桥","brd":"枫花园汽车影院","distance":0,"follow":0,"imax":0,"sellPrice":0,"poiId":271415,"lat":39.958447,"lng":116.48107,"sell":false,"sellmin":0,"preferential":0,"area":"chaoyang","brdId":651783,"dealPrice":0,"referencePrice":100,"showCount":0,"id":254},{"addr":"chaoyang垡头西里44号垡头文化中心B1","nm":"曙光影院","ct":"","deal":1,"dis":"垡头西里","brd":"其它","distance":0,"follow":0,"imax":0,"sellPrice":0,"poiId":3305306,"lat":39.861492,"lng":116.51347,"sell":false,"sellmin":0,"preferential":0,"area":"chaoyang","brdId":0,"dealPrice":31,"referencePrice":0,"showCount":0,"id":4548},{"addr":"chaoyang南影路9号","nm":"中国电影博物馆","ct":"","deal":0,"dis":"草场地","brd":"其它","distance":0,"follow":0,"imax":1,"sellPrice":0,"poiId":1436410,"lat":39.9962,"lng":116.521,"sell":false,"sellmin":0,"preferential":0,"area":"chaoyang","brdId":0,"dealPrice":0,"referencePrice":40,"showCount":0,"id":181}],"haidian":[{"addr":"haidian文慧园路9号今典花园9号楼空间蒙太奇大厦1层","nm":"17.5影城(今典花园店)","ct":"","deal":1,"dis":"北太平庄","brd":"17.5影城","distance":0,"follow":0,"imax":0,"sellPrice":27,"poiId":273950,"lat":39.95334,"lng":116.36104,"sell":true,"sellmin":0,"preferential":0,"area":"haidian","brdId":23854,"dealPrice":30,"referencePrice":60,"showCount":0,"id":154},{"addr":"haidian西翠路5号今日家园8号楼苏宁电器地下一层（太平路沃尔玛超市旁）","nm":"17.5影城(今日家园店)","ct":"","deal":0,"dis":"五棵松","brd":"17.5影城","distance":0,"follow":0,"imax":0,"sellPrice":27,"poiId":3260713,"lat":39.900616,"lng":116.28245,"sell":true,"sellmin":0,"preferential":0,"area":"haidian","brdId":23854,"dealPrice":0,"referencePrice":70,"showCount":0,"id":102},{"addr":"haidian大钟寺四道口2号京果商厦B座三层北侧","nm":"17.5影城(四道口店)","ct":"","deal":0,"dis":"北下关","brd":"17.5影城","distance":0,"follow":0,"imax":0,"sellPrice":39,"poiId":48958,"lat":39.960403,"lng":116.34541,"sell":true,"sellmin":0,"preferential":0,"area":"haidian","brdId":23854,"dealPrice":0,"referencePrice":45,"showCount":0,"id":25},{"addr":"haidian清河中街68号华润五彩城购物中心东区7层","nm":"CGV星聚汇影城(清河店)","ct":"","deal":0,"dis":"","brd":"CGV星聚汇影城","distance":0,"follow":0,"imax":0,"sellPrice":57,"poiId":2374984,"lat":40.030476,"lng":116.334724,"sell":true,"sellmin":0,"preferential":0,"area":"haidian","brdId":2020418,"dealPrice":0,"referencePrice":40,"showCount":0,"id":5111},{"addr":"haidian双榆树科学院南路44号（双安商场对面）","nm":"UME国际影城(华星店)","ct":"","deal":0,"dis":"中关村","brd":"UME国际影城","distance":0,"follow":0,"imax":1,"sellPrice":39.5,"poiId":1436373,"lat":39.967793,"lng":116.326096,"sell":true,"sellmin":0,"preferential":0,"area":"haidian","brdId":24071,"dealPrice":0,"referencePrice":70,"showCount":0,"id":155},{"addr":"haidian复兴路51号凯德晶品购物中心4层","nm":"博纳国际影城(万寿路店)","ct":"","deal":0,"dis":"万寿路","brd":"博纳国际影城","distance":0,"follow":0,"imax":0,"sellPrice":44,"poiId":1460949,"lat":39.908405,"lng":116.29659,"sell":true,"sellmin":0,"preferential":0,"area":"haidian","brdId":24595,"dealPrice":0,"referencePrice":80,"showCount":0,"id":1624},{"addr":"haidian玉海园五里22号配套商业楼（原吉彩体育馆）","nm":"橙天嘉禾影城(吉彩店)","ct":"","deal":0,"dis":"","brd":"橙天嘉禾影城","distance":0,"follow":0,"imax":0,"sellPrice":24.5,"poiId":2393106,"lat":39.922768,"lng":116.25956,"sell":true,"sellmin":0,"preferential":0,"area":"haidian","brdId":24745,"dealPrice":0,"referencePrice":80,"showCount":0,"id":5313},{"addr":"haidian上地南口华联商厦4F","nm":"橙天嘉禾影城(上地店)","ct":"","deal":0,"dis":"上地","brd":"橙天嘉禾影城","distance":0,"follow":0,"imax":0,"sellPrice":33.5,"poiId":14447,"lat":40.02865,"lng":116.31154,"sell":true,"sellmin":0,"preferential":0,"area":"haidian","brdId":24745,"dealPrice":0,"referencePrice":80,"showCount":0,"id":130},{"addr":"haidian巴沟路2号华联万柳购物中心5层","nm":"橙天嘉禾影城(万柳店)","ct":"","deal":0,"dis":"苏州桥","brd":"橙天嘉禾影城","distance":0,"follow":0,"imax":0,"sellPrice":33.5,"poiId":3303603,"lat":39.97296,"lng":116.29486,"sell":true,"sellmin":0,"preferential":0,"area":"haidian","brdId":24745,"dealPrice":0,"referencePrice":80,"showCount":0,"id":86},{"addr":"haidian悦秀路99号二层","nm":"大地影院(西三旗物美店)","ct":"","deal":1,"dis":"","brd":"大地影院","distance":0,"follow":0,"imax":0,"sellPrice":33,"poiId":4845675,"lat":40.04733,"lng":116.33703,"sell":true,"sellmin":0,"preferential":0,"area":"haidian","brdId":384262,"dealPrice":40.5,"referencePrice":0,"showCount":0,"id":7433},{"addr":"haidian花园东路甲16号","nm":"国安剧院","ct":"","deal":0,"dis":"北太平庄","brd":"其它","distance":0,"follow":0,"imax":0,"sellPrice":33,"poiId":294883,"lat":39.981472,"lng":116.37021,"sell":true,"sellmin":0,"preferential":0,"area":"haidian","brdId":0,"dealPrice":0,"referencePrice":80,"showCount":0,"id":251},{"addr":"haidian中关村南大街33号国家图书馆内","nm":"国图影院","ct":"","deal":0,"dis":"魏公村","brd":"其它","distance":0,"follow":0,"imax":0,"sellPrice":28,"poiId":271442,"lat":39.94304,"lng":116.32312,"sell":true,"sellmin":0,"preferential":0,"area":"haidian","brdId":0,"dealPrice":0,"referencePrice":60,"showCount":0,"id":238},{"addr":"haidian万柳华府北街2号（万柳华联商城南门对面）","nm":"海淀工人文化宫","ct":"","deal":1,"dis":"苏州桥","brd":"其它","distance":0,"follow":0,"imax":0,"sellPrice":33,"poiId":38025,"lat":39.971443,"lng":116.295105,"sell":true,"sellmin":0,"preferential":0,"area":"haidian","brdId":0,"dealPrice":28,"referencePrice":30,"showCount":0,"id":141},{"addr":"haidian中关村大街28号","nm":"海淀剧院","ct":"","deal":1,"dis":"中关村","brd":"其它","distance":0,"follow":0,"imax":0,"sellPrice":38,"poiId":17899,"lat":39.97669,"lng":116.31822,"sell":true,"sellmin":0,"preferential":0,"area":"haidian","brdId":0,"dealPrice":31,"referencePrice":80,"showCount":0,"id":257},{"addr":"haidian学清路甲8号圣熙8号购物中心5层西侧","nm":"嘉华国际影城(学清路店)","ct":"","deal":1,"dis":"五道口","brd":"嘉华国际影城","distance":0,"follow":0,"imax":0,"sellPrice":44,"poiId":84440,"lat":40.008587,"lng":116.35387,"sell":true,"sellmin":0,"preferential":0,"area":"haidian","brdId":26413,"dealPrice":35,"referencePrice":70,"showCount":0,"id":70},{"addr":"haidian西三旗建材城中路6号新都购物广场1层","nm":"金逸影城(新都店)","ct":"","deal":0,"dis":"清河","brd":"金逸影城","distance":0,"follow":0,"imax":0,"sellPrice":29,"poiId":1549060,"lat":40.060005,"lng":116.36541,"sell":true,"sellmin":0,"preferential":0,"area":"haidian","brdId":1079568,"dealPrice":0,"referencePrice":60,"showCount":0,"id":58},{"addr":"haidian中关村大街19号新中关购物中心B1层","nm":"金逸影城(中关村店)","ct":"","deal":0,"dis":"中关村","brd":"金逸影城","distance":0,"follow":0,"imax":0,"sellPrice":49,"poiId":276722,"lat":39.978382,"lng":116.31445,"sell":true,"sellmin":0,"preferential":0,"area":"haidian","brdId":1079568,"dealPrice":0,"referencePrice":80,"showCount":0,"id":152},{"addr":"haidian中关村大街15号中关村广场购物中心津乐汇3楼（地铁中关村站D口出西侧）","nm":"美嘉欢乐影城(中关村店)","ct":"","deal":1,"dis":"中关村","brd":"美嘉欢乐影城","distance":0,"follow":0,"imax":0,"sellPrice":49,"poiId":279439,"lat":39.983105,"lng":116.31355,"sell":true,"sellmin":0,"preferential":0,"area":"haidian","brdId":27617,"dealPrice":43.9,"referencePrice":24,"showCount":0,"id":197},{"addr":"haidian羊坊店路18号光耀东方4层","nm":"世茂国际影城","ct":"","deal":0,"dis":"","brd":"世茂国际影城","distance":0,"follow":0,"imax":0,"sellPrice":23,"poiId":3251410,"lat":39.899376,"lng":116.32227,"sell":true,"sellmin":0,"preferential":0,"area":"haidian","brdId":28741,"dealPrice":0,"referencePrice":0,"showCount":0,"id":6483},{"addr":"haidian北三环中路中视云投大厦","nm":"天幕新彩云国际影城","ct":"","deal":0,"dis":"","brd":"其它","distance":0,"follow":0,"imax":0,"sellPrice":33,"poiId":4480546,"lat":39.969345,"lng":116.3678,"sell":true,"sellmin":0,"preferential":0,"area":"haidian","brdId":0,"dealPrice":0,"referencePrice":0,"showCount":0,"id":13003},{"addr":"haidian成府路23号（近五道口城铁站）","nm":"五道口工人俱乐部电影院","ct":"","deal":1,"dis":"五道口","brd":"其它","distance":0,"follow":0,"imax":0,"sellPrice":33,"poiId":82591,"lat":39.99351,"lng":116.33939,"sell":true,"sellmin":0,"preferential":0,"area":"haidian","brdId":0,"dealPrice":31,"referencePrice":35,"showCount":0,"id":258},{"addr":"haidian西四环北路金四季购物中心中段三层B003","nm":"万画影城","ct":"","deal":0,"dis":"","brd":"其它","distance":0,"follow":0,"imax":0,"sellPrice":28,"poiId":41066531,"lat":39.94469,"lng":116.27137,"sell":true,"sellmin":0,"preferential":0,"area":"haidian","brdId":0,"dealPrice":0,"referencePrice":0,"showCount":0,"id":13054},{"addr":"haidian宝盛北里西区28号兴美生活广场5层","nm":"新华国际影城(宝盛店)","ct":"","deal":1,"dis":"","brd":"新华国际影城","distance":0,"follow":0,"imax":0,"sellPrice":33,"poiId":2408760,"lat":40.037056,"lng":116.370605,"sell":true,"sellmin":0,"preferential":0,"area":"haidian","brdId":29894,"dealPrice":26,"referencePrice":70,"showCount":0,"id":5359},{"addr":"haidian北三环18号院大钟寺中坤广场C座3层（地铁13号线大钟寺站出站即到）","nm":"新华国际影城(大钟寺店)","ct":"","deal":0,"dis":"大钟寺","brd":"新华国际影城","distance":0,"follow":0,"imax":0,"sellPrice":38,"poiId":1524564,"lat":39.96573,"lng":116.34114,"sell":true,"sellmin":0,"preferential":0,"area":"haidian","brdId":29894,"dealPrice":0,"referencePrice":80,"showCount":0,"id":1589},{"addr":"haidian远大路1号金源时代购物中心5楼东首（近蓝靛厂北路）","nm":"星美国际影城(金源店)","ct":"","deal":0,"dis":"远大路","brd":"星美国际影城","distance":0,"follow":0,"imax":0,"sellPrice":60,"poiId":271447,"lat":39.95867,"lng":116.2889,"sell":true,"sellmin":0,"preferential":0,"area":"haidian","brdId":30032,"dealPrice":0,"referencePrice":35,"showCount":0,"id":271},{"addr":"haidian复兴路69号卓展购物中心5层","nm":"耀莱成龙国际影城(五棵松店)","ct":"","deal":1,"dis":"五棵松","brd":"耀莱成龙国际影城","distance":0,"follow":0,"imax":0,"sellPrice":38,"poiId":335220,"lat":39.913418,"lng":116.2794,"sell":true,"sellmin":0,"preferential":0,"area":"haidian","brdId":30227,"dealPrice":35,"referencePrice":70,"showCount":0,"id":87},{"addr":"haidian杏石口路中间艺术园区内","nm":"中间影院","ct":"","deal":0,"dis":"","brd":"其它","distance":0,"follow":0,"imax":0,"sellPrice":23,"poiId":4572438,"lat":39.95388,"lng":116.23189,"sell":true,"sellmin":0,"preferential":0,"area":"haidian","brdId":0,"dealPrice":0,"referencePrice":0,"showCount":0,"id":9459},{"addr":"haidian新街口外大街25号（小西天牌楼北侧）","nm":"中影电影院(新街口店)","ct":"","deal":0,"dis":"","brd":"中影国际影城","distance":0,"follow":0,"imax":0,"sellPrice":39,"poiId":82594,"lat":39.95296,"lng":116.37117,"sell":true,"sellmin":0,"preferential":0,"area":"haidian","brdId":23745,"dealPrice":0,"referencePrice":0,"showCount":0,"id":9916},{"addr":"haidian花园路甲13号庚坊国际发展中心B1层","nm":"华影国际影城(花园路店)","ct":"","deal":0,"dis":"","brd":"华影国际影城","distance":0,"follow":0,"imax":0,"sellPrice":0,"poiId":4744457,"lat":39.972046,"lng":116.36422,"sell":false,"sellmin":0,"preferential":0,"area":"haidian","brdId":271399,"dealPrice":0,"referencePrice":0,"showCount":0,"id":7985},{"addr":"haidian文慧园路3号","nm":"中国电影资料馆","ct":"","deal":0,"dis":"新街口","brd":"其它","distance":0,"follow":0,"imax":0,"sellPrice":33,"poiId":1541424,"lat":39.953133,"lng":116.36986,"sell":false,"sellmin":0,"preferential":0,"area":"haidian","brdId":0,"dealPrice":0,"referencePrice":0,"showCount":0,"id":2010}],"dongcheng":[{"addr":"dongcheng北三环安贞桥环球贸易中心E座","nm":"UME国际影城(安贞店)","ct":"","deal":0,"dis":"安贞","brd":"UME国际影城","distance":0,"follow":0,"imax":0,"sellPrice":39.5,"poiId":94496,"lat":39.966072,"lng":116.41096,"sell":true,"sellmin":0,"preferential":0,"area":"dongcheng","brdId":24071,"dealPrice":0,"referencePrice":70,"showCount":0,"id":99},{"addr":"dongcheng金宝街88号金宝汇7层","nm":"百丽宫影城(金宝汇店)","ct":"","deal":0,"dis":"王府井","brd":"百老汇影城","distance":0,"follow":0,"imax":0,"sellPrice":33,"poiId":1076058,"lat":39.9152,"lng":116.42129,"sell":true,"sellmin":0,"preferential":0,"area":"dongcheng","brdId":24377,"dealPrice":0,"referencePrice":80,"showCount":0,"id":122},{"addr":"dongcheng香河园路1号当代MOMA北区T4座","nm":"百老汇电影中心","ct":"","deal":0,"dis":"东直门","brd":"百老汇影城","distance":0,"follow":0,"imax":0,"sellPrice":43,"poiId":1076062,"lat":39.950455,"lng":116.43878,"sell":true,"sellmin":0,"preferential":0,"area":"dongcheng","brdId":24377,"dealPrice":0,"referencePrice":80,"showCount":0,"id":94},{"addr":"dongcheng王府井大街138号北京apm6层","nm":"百老汇影城(apm购物中心店)","ct":"","deal":0,"dis":"王府井","brd":"百老汇影城","distance":0,"follow":0,"imax":0,"sellPrice":43,"poiId":271444,"lat":39.914005,"lng":116.41193,"sell":true,"sellmin":0,"preferential":0,"area":"dongcheng","brdId":24377,"dealPrice":0,"referencePrice":70,"showCount":0,"id":267},{"addr":"dongcheng东长安街1号东方广场地下1层","nm":"百老汇影城(东方广场店)","ct":"","deal":0,"dis":"王府井","brd":"百老汇影城","distance":0,"follow":0,"imax":0,"sellPrice":43,"poiId":271409,"lat":39.909454,"lng":116.411934,"sell":true,"sellmin":0,"preferential":0,"area":"dongcheng","brdId":24377,"dealPrice":0,"referencePrice":40,"showCount":0,"id":269},{"addr":"dongcheng崇文门外大街18号国瑞城购物中心首层/-2层","nm":"百老汇影城(国瑞购物中心店)","ct":"","deal":0,"dis":"崇文门","brd":"百老汇影城","distance":0,"follow":0,"imax":0,"sellPrice":43,"poiId":1048975,"lat":39.897575,"lng":116.420135,"sell":true,"sellmin":0,"preferential":0,"area":"dongcheng","brdId":24377,"dealPrice":0,"referencePrice":80,"showCount":0,"id":119},{"addr":"dongcheng隆福寺街47号东四工人文化宫","nm":"东宫影剧院","ct":"","deal":0,"dis":"东四","brd":"东宫影剧院","distance":0,"follow":0,"imax":0,"sellPrice":31,"poiId":60166,"lat":39.9253,"lng":116.41552,"sell":true,"sellmin":0,"preferential":0,"area":"dongcheng","brdId":125212,"dealPrice":0,"referencePrice":30,"showCount":0,"id":242},{"addr":"dongcheng东中街9号东环广场B座B1楼","nm":"东环影城","ct":"","deal":1,"dis":"东直门","brd":"东环影城","distance":0,"follow":0,"imax":0,"sellPrice":38,"poiId":43786,"lat":39.936527,"lng":116.43607,"sell":true,"sellmin":0,"preferential":0,"area":"dongcheng","brdId":25181,"dealPrice":29,"referencePrice":80,"showCount":0,"id":265},{"addr":"dongcheng王府井大街251-253号8层","nm":"横店电影城(王府井店)","ct":"","deal":1,"dis":"王府井","brd":"横店电影城","distance":0,"follow":0,"imax":0,"sellPrice":24,"poiId":1549949,"lat":39.91331,"lng":116.410545,"sell":true,"sellmin":0,"preferential":0,"area":"dongcheng","brdId":26045,"dealPrice":31,"referencePrice":70,"showCount":0,"id":79},{"addr":"dongcheng东滨河路乙一号雍和航星园内","nm":"青春光线电影院","ct":"","deal":0,"dis":"","brd":"其它","distance":0,"follow":0,"imax":0,"sellPrice":28,"poiId":99389254,"lat":39.95059,"lng":116.42174,"sell":true,"sellmin":0,"preferential":0,"area":"dongcheng","brdId":0,"dealPrice":0,"referencePrice":0,"showCount":0,"id":15280},{"addr":"dongcheng崇外大街40号搜秀城9层","nm":"搜秀影城","ct":"","deal":1,"dis":"崇文门","brd":"搜秀影城","distance":0,"follow":0,"imax":0,"sellPrice":43,"poiId":82579,"lat":39.896397,"lng":116.419266,"sell":true,"sellmin":0,"preferential":0,"area":"dongcheng","brdId":28916,"dealPrice":36,"referencePrice":80,"showCount":0,"id":270},{"addr":"dongcheng王府井大街301号新燕莎购物中心地下一层西侧（地铁一号线王府井站出C2口向北步行200米路西）","nm":"耀莱成龙国际影城(王府井店)","ct":"","deal":1,"dis":"","brd":"耀莱成龙国际影城","distance":0,"follow":0,"imax":0,"sellPrice":33,"poiId":6074394,"lat":39.90959,"lng":116.41121,"sell":true,"sellmin":0,"preferential":0,"area":"dongcheng","brdId":30227,"dealPrice":30,"referencePrice":0,"showCount":0,"id":10781},{"addr":"dongcheng毛家湾胡同甲13号站西侧3层","nm":"北京站电影院","ct":"","deal":0,"dis":"","brd":"其它","distance":0,"follow":0,"imax":0,"sellPrice":0,"poiId":52795616,"lat":39.903954,"lng":116.4272,"sell":false,"sellmin":0,"preferential":0,"area":"dongcheng","brdId":0,"dealPrice":0,"referencePrice":0,"showCount":0,"id":14472},{"addr":"dongcheng交道口东大街85号区图书馆1楼","nm":"东城图书馆影剧院","ct":"","deal":0,"dis":"东四","brd":"其它","distance":0,"follow":0,"imax":0,"sellPrice":0,"poiId":271413,"lat":39.941,"lng":116.413,"sell":false,"sellmin":0,"preferential":0,"area":"dongcheng","brdId":0,"dealPrice":0,"referencePrice":0,"showCount":0,"id":4541}],"fengtai":[{"addr":"fengtai南三环西路16号凯德大峡谷购物中心5楼","nm":"保利国际影城(凯德MALL·大峡谷店)","ct":"","deal":0,"dis":"草桥","brd":"保利国际影城","distance":0,"follow":0,"imax":0,"sellPrice":39,"poiId":339944,"lat":39.854645,"lng":116.36706,"sell":true,"sellmin":0,"preferential":0,"area":"fengtai","brdId":24472,"dealPrice":0,"referencePrice":40,"showCount":0,"id":42},{"addr":"fengtai东高地万源西里航天万源广场5层","nm":"保利国际影城(万源店)","ct":"","deal":1,"dis":"东高地","brd":"保利国际影城","distance":0,"follow":0,"imax":0,"sellPrice":39,"poiId":299479,"lat":39.80296,"lng":116.423454,"sell":true,"sellmin":0,"preferential":0,"area":"fengtai","brdId":24472,"dealPrice":27,"referencePrice":70,"showCount":0,"id":129},{"addr":"fengtai蒲黄榆路28号","nm":"博纳国际影城(方庄店)","ct":"","deal":0,"dis":"方庄","brd":"博纳国际影城","distance":0,"follow":0,"imax":0,"sellPrice":49,"poiId":82556,"lat":39.863983,"lng":116.42227,"sell":true,"sellmin":0,"preferential":0,"area":"fengtai","brdId":24595,"dealPrice":0,"referencePrice":80,"showCount":0,"id":43},{"addr":"fengtai果园8号楼临三环（木樨园桥-西南角欣雅汇生活广场6层）","nm":"大地影院(欣雅汇店)","ct":"","deal":1,"dis":"","brd":"大地影院","distance":0,"follow":0,"imax":0,"sellPrice":33,"poiId":78978010,"lat":39.855907,"lng":116.397896,"sell":true,"sellmin":0,"preferential":0,"area":"fengtai","brdId":384262,"dealPrice":40.5,"referencePrice":0,"showCount":0,"id":15070},{"addr":"fengtai马家堡东路101号院10号银泰百货6层","nm":"华谊兄弟影院(洋桥店)","ct":"","deal":0,"dis":"","brd":"华谊兄弟影院","distance":0,"follow":0,"imax":1,"sellPrice":29,"poiId":1547150,"lat":39.84446,"lng":116.38594,"sell":true,"sellmin":0,"preferential":0,"area":"fengtai","brdId":275830,"dealPrice":0,"referencePrice":80,"showCount":0,"id":2548},{"addr":"fengtai西四环南路86号","nm":"青少年剧场","ct":"","deal":0,"dis":"","brd":"其它","distance":0,"follow":0,"imax":0,"sellPrice":33,"poiId":271414,"lat":39.851784,"lng":116.28421,"sell":true,"sellmin":0,"preferential":0,"area":"fengtai","brdId":0,"dealPrice":0,"referencePrice":0,"showCount":0,"id":4542},{"addr":"fengtai角门路19号院2号楼华冠天地4层（原大万广场）","nm":"幸福蓝海国际影城(北京公益桥店)","ct":"","deal":0,"dis":"","brd":"幸福蓝海国际影城","distance":0,"follow":0,"imax":0,"sellPrice":24,"poiId":5161700,"lat":39.836674,"lng":116.37848,"sell":true,"sellmin":0,"preferential":0,"area":"fengtai","brdId":30053,"dealPrice":0,"referencePrice":0,"showCount":0,"id":8578},{"addr":"fengtai南三环东路成寿寺路2号新业广场2楼","nm":"星美国际影城(分钟寺店)","ct":"","deal":0,"dis":"方庄","brd":"星美国际影城","distance":0,"follow":0,"imax":0,"sellPrice":14,"poiId":1436294,"lat":39.857136,"lng":116.44611,"sell":true,"sellmin":0,"preferential":0,"area":"fengtai","brdId":30032,"dealPrice":0,"referencePrice":35,"showCount":0,"id":9},{"addr":"fengtai宋家庄顺八条4号政馨园三区5号楼底商正华商城地下一层","nm":"正华影院","ct":"","deal":0,"dis":"方庄","brd":"正华影城","distance":0,"follow":0,"imax":0,"sellPrice":33,"poiId":82600,"lat":39.845528,"lng":116.43179,"sell":true,"sellmin":0,"preferential":0,"area":"fengtai","brdId":677942,"dealPrice":0,"referencePrice":60,"showCount":0,"id":63},{"addr":"fengtai靛场路千禧商业街4号楼","nm":"中影国际影城(丰台千禧街店)","ct":"","deal":0,"dis":"","brd":"中影国际影城","distance":0,"follow":0,"imax":0,"sellPrice":29,"poiId":6458108,"lat":39.889786,"lng":116.287766,"sell":true,"sellmin":0,"preferential":0,"area":"fengtai","brdId":23745,"dealPrice":0,"referencePrice":30,"showCount":0,"id":7634},{"addr":"fengtai丰葆路永旺梦乐城4层","nm":"中影国际影城(丰台永旺店)","ct":"","deal":0,"dis":"","brd":"其它","distance":0,"follow":0,"imax":0,"sellPrice":29,"poiId":77423086,"lat":39.817265,"lng":116.292496,"sell":true,"sellmin":0,"preferential":0,"area":"fengtai","brdId":0,"dealPrice":0,"referencePrice":0,"showCount":0,"id":14384},{"addr":"fengtai开阳路8号悦秀城6层","nm":"DMG国际影城(悦秀店)","ct":"","deal":0,"dis":"","brd":"其它","distance":0,"follow":0,"imax":0,"sellPrice":0,"poiId":94444126,"lat":39.86373,"lng":116.36722,"sell":false,"sellmin":0,"preferential":0,"area":"fengtai","brdId":0,"dealPrice":0,"referencePrice":0,"showCount":0,"id":15859},{"addr":"fengtai市辖区fengtai西四环南路38号-1","nm":"北京中鼎兆通信息科技电影放映中心影院","ct":"","deal":0,"dis":"","brd":"其它","distance":0,"follow":0,"imax":0,"sellPrice":0,"poiId":95577364,"lat":39.856148,"lng":116.28398,"sell":false,"sellmin":0,"preferential":0,"area":"fengtai","brdId":0,"dealPrice":0,"referencePrice":0,"showCount":0,"id":15271}],"daxing":[{"addr":"daxing金星西路3号绿地缤纷城购物中心4层","nm":"保利国际影城(绿地缤纷城店)","ct":"","deal":0,"dis":"绿地缤纷城","brd":"保利国际影城","distance":0,"follow":0,"imax":0,"sellPrice":39,"poiId":1481117,"lat":39.764683,"lng":116.33354,"sell":true,"sellmin":0,"preferential":0,"area":"daxing","brdId":24472,"dealPrice":0,"referencePrice":70,"showCount":0,"id":2392},{"addr":"daxing亦庄经济开发区文化园东路6号创意生活广场三层","nm":"大料国际影城(创意生活广场店)","ct":"","deal":0,"dis":"亦庄","brd":"大料国际影城","distance":0,"follow":0,"imax":0,"sellPrice":28,"poiId":82601,"lat":39.810535,"lng":116.50513,"sell":true,"sellmin":0,"preferential":0,"area":"daxing","brdId":24930,"dealPrice":0,"referencePrice":80,"showCount":0,"id":34},{"addr":"daxing黄村西大街15号","nm":"大兴影剧院","ct":"","deal":0,"dis":"黄村","brd":"大兴剧院","distance":0,"follow":0,"imax":0,"sellPrice":23,"poiId":324698,"lat":39.7323,"lng":116.338005,"sell":true,"sellmin":0,"preferential":0,"area":"daxing","brdId":381835,"dealPrice":0,"referencePrice":21,"showCount":0,"id":179},{"addr":"daxing旧宫小红门路39号","nm":"嘉美国际影城(旧宫店)","ct":"","deal":0,"dis":"","brd":"嘉美国际影城","distance":0,"follow":0,"imax":0,"sellPrice":23,"poiId":6685358,"lat":39.814774,"lng":116.454636,"sell":true,"sellmin":0,"preferential":0,"area":"daxing","brdId":352923,"dealPrice":0,"referencePrice":70,"showCount":0,"id":2598},{"addr":"daxing欣宁街荟聚购物中心3层（地铁4号线西红门站A西出口站）","nm":"金逸影城(荟聚IMAX店)","ct":"","deal":0,"dis":"","brd":"金逸影城","distance":0,"follow":0,"imax":1,"sellPrice":39,"poiId":40697227,"lat":39.78632,"lng":116.32738,"sell":true,"sellmin":0,"preferential":0,"area":"daxing","brdId":1079568,"dealPrice":0,"referencePrice":0,"showCount":0,"id":10987},{"addr":"daxing忠凉路万科广场5层","nm":"卢米埃影城(万科店)","ct":"","deal":0,"dis":"","brd":"其它","distance":0,"follow":0,"imax":0,"sellPrice":28,"poiId":93511270,"lat":39.80576,"lng":116.460175,"sell":true,"sellmin":0,"preferential":0,"area":"daxing","brdId":0,"dealPrice":0,"referencePrice":0,"showCount":0,"id":15773},{"addr":"daxing经济技术开发区荣华中路8号院华联力宝购物中心四层","nm":"唐阁影城(亦庄店)","ct":"","deal":0,"dis":"","brd":"其它","distance":0,"follow":0,"imax":0,"sellPrice":39,"poiId":5165994,"lat":39.806152,"lng":116.50166,"sell":true,"sellmin":0,"preferential":0,"area":"daxing","brdId":0,"dealPrice":0,"referencePrice":0,"showCount":0,"id":11132},{"addr":"daxing黄村东大街火神庙国际商业中心E座5层","nm":"新华国际影城(大兴店)","ct":"","deal":1,"dis":"黄村","brd":"新华国际影城","distance":0,"follow":0,"imax":0,"sellPrice":31,"poiId":86394,"lat":39.72971,"lng":116.34167,"sell":true,"sellmin":0,"preferential":0,"area":"daxing","brdId":29894,"dealPrice":36,"referencePrice":40,"showCount":0,"id":11},{"addr":"daxing西红门镇京良路10号乐家购物中心B区3层","nm":"星美国际影城(西红门店)","ct":"","deal":0,"dis":"","brd":"星美国际影城","distance":0,"follow":0,"imax":0,"sellPrice":4.01,"poiId":2490890,"lat":39.799633,"lng":116.33217,"sell":true,"sellmin":0,"preferential":0,"area":"daxing","brdId":30032,"dealPrice":0,"referencePrice":70,"showCount":0,"id":6057},{"addr":"daxing欣旺北大街8号鸿坤广场6层（地铁4号线西红门站Ｂ口向东４００米路北）","nm":"耀莱成龙国际影城(西红门店)","ct":"","deal":1,"dis":"","brd":"耀莱成龙国际影城","distance":0,"follow":0,"imax":0,"sellPrice":23,"poiId":41278576,"lat":39.791393,"lng":116.340256,"sell":true,"sellmin":0,"preferential":0,"area":"daxing","brdId":30227,"dealPrice":25,"referencePrice":0,"showCount":0,"id":11082},{"addr":"daxing经济技术开发区科创五街38号C座3层F3-C3006","nm":"中传国际影城(亦庄店)","ct":"","deal":0,"dis":"","brd":"其它","distance":0,"follow":0,"imax":0,"sellPrice":33,"poiId":93839693,"lat":39.803543,"lng":116.53282,"sell":true,"sellmin":0,"preferential":0,"area":"daxing","brdId":0,"dealPrice":0,"referencePrice":0,"showCount":0,"id":15294},{"addr":"daxing兴华大街百联清城购物中心3层北侧","nm":"最影城","ct":"","deal":1,"dis":"","brd":"其它","distance":0,"follow":0,"imax":0,"sellPrice":28,"poiId":95968537,"lat":39.73894,"lng":116.33174,"sell":true,"sellmin":0,"preferential":0,"area":"daxing","brdId":0,"dealPrice":29.6,"referencePrice":0,"showCount":0,"id":15018},{"addr":"daxing东大路多维创新园内","nm":"玫瑰之约汽车影院(半壁店)","ct":"","deal":0,"dis":"","brd":"其它","distance":0,"follow":0,"imax":0,"sellPrice":0,"poiId":51400779,"lat":39.629345,"lng":116.38453,"sell":false,"sellmin":0,"preferential":0,"area":"daxing","brdId":0,"dealPrice":0,"referencePrice":0,"showCount":0,"id":14054}],"xicheng":[{"addr":"xicheng西直门南小街68号","nm":"北京青年宫","ct":"","deal":0,"dis":"西直门","brd":"其它","distance":0,"follow":0,"imax":0,"sellPrice":38,"poiId":271434,"lat":39.93531,"lng":116.35955,"sell":true,"sellmin":0,"preferential":0,"area":"xicheng","brdId":0,"dealPrice":0,"referencePrice":50,"showCount":0,"id":260},{"addr":"xicheng前门大街大栅栏街36号","nm":"大观楼电影院","ct":"","deal":0,"dis":"大栅栏","brd":"大观楼影城","distance":0,"follow":0,"imax":0,"sellPrice":34,"poiId":89010,"lat":39.895596,"lng":116.39515,"sell":true,"sellmin":0,"preferential":0,"area":"xicheng","brdId":392770,"dealPrice":0,"referencePrice":60,"showCount":0,"id":263},{"addr":"xicheng西四羊肉胡同30号（中国地质博物馆南侧）","nm":"地质礼堂","ct":"","deal":0,"dis":"西四","brd":"地质礼堂","distance":0,"follow":0,"imax":0,"sellPrice":38,"poiId":89006,"lat":39.922535,"lng":116.371346,"sell":true,"sellmin":0,"preferential":0,"area":"xicheng","brdId":368740,"dealPrice":0,"referencePrice":50,"showCount":0,"id":261},{"addr":"xicheng白广路8号","nm":"广安门电影院","ct":"","deal":0,"dis":"广内大街","brd":"其它","distance":0,"follow":0,"imax":0,"sellPrice":34,"poiId":82592,"lat":39.88407,"lng":116.35917,"sell":true,"sellmin":0,"preferential":0,"area":"xicheng","brdId":0,"dealPrice":0,"referencePrice":40,"showCount":0,"id":247},{"addr":"xicheng月坛南街24号（近万方商场）","nm":"国宾菁英电影院","ct":"","deal":0,"dis":"月坛","brd":"其它","distance":0,"follow":0,"imax":0,"sellPrice":33,"poiId":274294,"lat":39.913624,"lng":116.34325,"sell":true,"sellmin":0,"preferential":0,"area":"xicheng","brdId":0,"dealPrice":0,"referencePrice":40,"showCount":0,"id":255},{"addr":"xicheng虎坊路口南7号","nm":"工人俱乐部电影院","ct":"","deal":0,"dis":"虎坊桥","brd":"其它","distance":0,"follow":0,"imax":0,"sellPrice":33,"poiId":1436438,"lat":39.888065,"lng":116.38378,"sell":true,"sellmin":0,"preferential":0,"area":"xicheng","brdId":0,"dealPrice":0,"referencePrice":60,"showCount":0,"id":237},{"addr":"xicheng金融大街18号地下一层","nm":"首都电影院(金融街店)","ct":"","deal":0,"dis":"复兴门","brd":"首都电影院","distance":0,"follow":0,"imax":0,"sellPrice":44,"poiId":1541415,"lat":39.9151,"lng":116.36,"sell":true,"sellmin":0,"preferential":0,"area":"xicheng","brdId":1162239,"dealPrice":0,"referencePrice":80,"showCount":0,"id":1625},{"addr":"xicheng西单北大街131号大悦城10楼","nm":"首都电影院(西单店)","ct":"","deal":0,"dis":"西单","brd":"首都电影院","distance":0,"follow":0,"imax":0,"sellPrice":44,"poiId":283722,"lat":39.91066,"lng":116.373665,"sell":true,"sellmin":0,"preferential":0,"area":"xicheng","brdId":1162239,"dealPrice":0,"referencePrice":60,"showCount":0,"id":149},{"addr":"xicheng天桥南大街3号楼一层、二层","nm":"首都电影院(中华店)","ct":"","deal":0,"dis":"","brd":"其它","distance":0,"follow":0,"imax":0,"sellPrice":39,"poiId":93439511,"lat":39.884457,"lng":116.39819,"sell":true,"sellmin":0,"preferential":0,"area":"xicheng","brdId":0,"dealPrice":0,"referencePrice":0,"showCount":0,"id":15270},{"addr":"xicheng马连道路25号新年华生活购物广场5层","nm":"耀莱成龙国际影城(马连道店)","ct":"","deal":1,"dis":"","brd":"耀莱成龙国际影城","distance":0,"follow":0,"imax":0,"sellPrice":38,"poiId":2393654,"lat":39.877544,"lng":116.32643,"sell":true,"sellmin":0,"preferential":0,"area":"xicheng","brdId":30227,"dealPrice":30,"referencePrice":70,"showCount":0,"id":5278},{"addr":"xicheng新街口北大街74号（近北京科学教育电影制片厂院内）","nm":"剧空间剧场","ct":"","deal":0,"dis":"","brd":"其它","distance":0,"follow":0,"imax":0,"sellPrice":0,"poiId":73944402,"lat":39.94392,"lng":116.37328,"sell":false,"sellmin":0,"preferential":0,"area":"xicheng","brdId":0,"dealPrice":0,"referencePrice":0,"showCount":0,"id":14387},{"addr":"xicheng西单北大街180号西单文化广场","nm":"西单4D数字影院","ct":"","deal":0,"dis":"西单","brd":"西单4d数字影院","distance":0,"follow":0,"imax":0,"sellPrice":0,"poiId":271397,"lat":39.90875,"lng":116.37512,"sell":false,"sellmin":0,"preferential":0,"area":"xicheng","brdId":2876716,"dealPrice":0,"referencePrice":70,"showCount":0,"id":137},{"addr":"xicheng西直门内大街69号","nm":"新街口电影院","ct":"","deal":0,"dis":"西直门","brd":"新街口电影院","distance":0,"follow":0,"imax":0,"sellPrice":0,"poiId":82590,"lat":39.94168,"lng":116.37024,"sell":false,"sellmin":0,"preferential":0,"area":"xicheng","brdId":593182,"dealPrice":0,"referencePrice":50,"showCount":0,"id":243}],"tongzhou":[{"addr":"tongzhou杨庄北里52号华联天时名苑购物中心4楼（近通州北苑地铁站）","nm":"博纳国际影城(通州北苑店)","ct":"","deal":0,"dis":"新华联","brd":"博纳国际影城","distance":0,"follow":0,"imax":0,"sellPrice":39,"poiId":363447,"lat":39.903496,"lng":116.6367,"sell":true,"sellmin":0,"preferential":0,"area":"tongzhou","brdId":24595,"dealPrice":0,"referencePrice":80,"showCount":0,"id":2},{"addr":"tongzhou八通线土桥地铁站向东900米华远好天地购物中心3层","nm":"博纳国际影城(通州土桥店)","ct":"","deal":1,"dis":"","brd":"其它","distance":0,"follow":0,"imax":0,"sellPrice":34,"poiId":51455681,"lat":39.86987,"lng":116.697586,"sell":true,"sellmin":0,"preferential":0,"area":"tongzhou","brdId":0,"dealPrice":29,"referencePrice":0,"showCount":0,"id":14381},{"addr":"tongzhou马驹桥镇百尚生活广场3楼","nm":"百尚影城","ct":"","deal":1,"dis":"","brd":"百尚影城","distance":0,"follow":0,"imax":0,"sellPrice":28,"poiId":2371476,"lat":39.752598,"lng":116.54536,"sell":true,"sellmin":0,"preferential":0,"area":"tongzhou","brdId":825664,"dealPrice":25,"referencePrice":0,"showCount":0,"id":6227},{"addr":"tongzhou马驹桥新海东路1号（豪润生活广场7层）","nm":"大地影城(米拉店)","ct":"","deal":1,"dis":"","brd":"大地影院","distance":0,"follow":0,"imax":0,"sellPrice":38,"poiId":6151046,"lat":39.760098,"lng":116.545555,"sell":true,"sellmin":0,"preferential":0,"area":"tongzhou","brdId":384262,"dealPrice":40.5,"referencePrice":0,"showCount":0,"id":8301},{"addr":"tongzhou运河西大街乔庄卜蜂莲花超市一层","nm":"佳合时光影城","ct":"","deal":1,"dis":"","brd":"其它","distance":0,"follow":0,"imax":0,"sellPrice":23,"poiId":4800806,"lat":39.891575,"lng":116.68774,"sell":true,"sellmin":0,"preferential":0,"area":"tongzhou","brdId":0,"dealPrice":30,"referencePrice":0,"showCount":0,"id":8654},{"addr":"tongzhou西海子西塔胡同1号","nm":"tongzhou电影院","ct":"","deal":0,"dis":"德外大街","brd":"tongzhou电影院","distance":0,"follow":0,"imax":0,"sellPrice":23,"poiId":82560,"lat":39.912743,"lng":116.66441,"sell":true,"sellmin":0,"preferential":0,"area":"tongzhou","brdId":1041607,"dealPrice":0,"referencePrice":60,"showCount":0,"id":178},{"addr":"tongzhou新华西街58号万达广场1号楼5层（厨艺宾馆对面）","nm":"万达国际影城(通州万达店)","ct":"","deal":0,"dis":"","brd":"万达影城","distance":0,"follow":0,"imax":1,"sellPrice":43,"poiId":41521114,"lat":39.905937,"lng":116.64272,"sell":true,"sellmin":0,"preferential":0,"area":"tongzhou","brdId":102642,"dealPrice":0,"referencePrice":0,"showCount":0,"id":10837},{"addr":"tongzhou临河里33号楼华业玫瑰商业中心D2号楼三层","nm":"耀莱成龙国际影城(临河里店)","ct":"","deal":1,"dis":"","brd":"耀莱成龙国际影城","distance":0,"follow":0,"imax":0,"sellPrice":28,"poiId":92950934,"lat":39.88119,"lng":116.68255,"sell":true,"sellmin":0,"preferential":0,"area":"tongzhou","brdId":30227,"dealPrice":25,"referencePrice":0,"showCount":0,"id":14634},{"addr":"tongzhou翠景北里21号京通罗斯福广场5F","nm":"银兴乐天影城(通州店)","ct":"","deal":0,"dis":"","brd":"乐天影城","distance":0,"follow":0,"imax":0,"sellPrice":38,"poiId":6139543,"lat":39.88967,"lng":116.659225,"sell":true,"sellmin":0,"preferential":0,"area":"tongzhou","brdId":157630,"dealPrice":0,"referencePrice":0,"showCount":0,"id":10964},{"addr":"tongzhou永顺镇芙蓉园513号楼","nm":"北京东融国际影城(月亮河店)","ct":"","deal":0,"dis":"","brd":"其它","distance":0,"follow":0,"imax":0,"sellPrice":0,"poiId":99968119,"lat":39.919525,"lng":116.677376,"sell":false,"sellmin":0,"preferential":0,"area":"tongzhou","brdId":0,"dealPrice":0,"referencePrice":0,"showCount":0,"id":15421},{"addr":"tongzhou台湖镇创业园路8号（近京沈高速台湖入口）","nm":"牛仔汽车电影院","ct":"","deal":0,"dis":"梨园","brd":"其它","distance":0,"follow":0,"imax":0,"sellPrice":0,"poiId":358821,"lat":39.84602,"lng":116.62319,"sell":false,"sellmin":0,"preferential":0,"area":"tongzhou","brdId":0,"dealPrice":0,"referencePrice":10,"showCount":0,"id":36}],"changping":[{"addr":"changping黄平路19号院3号楼龙旗广场购物中心3层（地铁8号线育新站路北600米，近永辉超市）","nm":"保利国际影城(龙旗广场店)","ct":"","deal":1,"dis":"回龙观","brd":"保利国际影城","distance":0,"follow":0,"imax":0,"sellPrice":39,"poiId":3320660,"lat":40.066605,"lng":116.34672,"sell":true,"sellmin":0,"preferential":0,"area":"changping","brdId":24472,"dealPrice":40,"referencePrice":100,"showCount":0,"id":5502},{"addr":"changping鼓楼南大街6号佳莲时代广场4楼（近鼓楼西街）","nm":"昌平保利影剧院(佳莲时代广场店)","ct":"","deal":0,"dis":"昌平镇","brd":"其它","distance":0,"follow":0,"imax":0,"sellPrice":33,"poiId":361208,"lat":40.223534,"lng":116.23402,"sell":true,"sellmin":0,"preferential":0,"area":"changping","brdId":0,"dealPrice":0,"referencePrice":80,"showCount":0,"id":50},{"addr":"changping昌崔路203号果岭假日广场四楼","nm":"大地影院(昌平菓岭店)","ct":"","deal":0,"dis":"昌平镇","brd":"大地影院","distance":0,"follow":0,"imax":0,"sellPrice":28,"poiId":1432377,"lat":40.222176,"lng":116.264755,"sell":true,"sellmin":0,"preferential":0,"area":"changping","brdId":384262,"dealPrice":0,"referencePrice":40,"showCount":0,"id":66},{"addr":"changping南环路10号院1号楼悦荟万科广场8层","nm":"首都电影院(悦荟万科广场店)","ct":"","deal":0,"dis":"","brd":"首都电影院","distance":0,"follow":0,"imax":0,"sellPrice":38,"poiId":373237,"lat":40.2124,"lng":116.24026,"sell":true,"sellmin":0,"preferential":0,"area":"changping","brdId":1162239,"dealPrice":0,"referencePrice":0,"showCount":0,"id":8186},{"addr":"changping立汤路186号龙德广场5层","nm":"万达国际影城(龙德广场店)","ct":"","deal":0,"dis":"天通苑","brd":"万达影城","distance":0,"follow":0,"imax":1,"sellPrice":43,"poiId":30864,"lat":40.060596,"lng":116.41618,"sell":true,"sellmin":0,"preferential":0,"area":"changping","brdId":102642,"dealPrice":0,"referencePrice":80,"showCount":0,"id":151},{"addr":"changping回龙观同成街华联购物中心四楼（城铁回龙观站出口对面）","nm":"沃美影城(回龙观店)","ct":"","deal":1,"dis":"","brd":"沃美影城","distance":0,"follow":0,"imax":0,"sellPrice":38,"poiId":4058821,"lat":40.071976,"lng":116.33717,"sell":true,"sellmin":0,"preferential":0,"area":"changping","brdId":29462,"dealPrice":40,"referencePrice":0,"showCount":0,"id":9647},{"addr":"changping回龙观西大街111号华联商场3楼","nm":"星美国际影城(回龙观店)","ct":"","deal":0,"dis":"回龙观","brd":"星美国际影城","distance":0,"follow":0,"imax":0,"sellPrice":14,"poiId":286187,"lat":40.07596,"lng":116.31944,"sell":true,"sellmin":0,"preferential":0,"area":"changping","brdId":30032,"dealPrice":0,"referencePrice":40,"showCount":0,"id":140},{"addr":"changping北清路1号永旺国际商城3楼","nm":"中影国际影城(昌平永旺店)","ct":"","deal":0,"dis":"回龙观","brd":"中影国际影城","distance":0,"follow":0,"imax":0,"sellPrice":39,"poiId":82598,"lat":40.09749,"lng":116.28857,"sell":true,"sellmin":0,"preferential":0,"area":"changping","brdId":23745,"dealPrice":0,"referencePrice":23,"showCount":0,"id":107}],"fangshan":[{"addr":"fangshan黄辛庄路口绿地缤纷城3层","nm":"SFC上影(房山店)","ct":"","deal":0,"dis":"","brd":"其它","distance":0,"follow":0,"imax":0,"sellPrice":38,"poiId":52294367,"lat":39.756683,"lng":116.160515,"sell":true,"sellmin":0,"preferential":0,"area":"fangshan","brdId":0,"dealPrice":0,"referencePrice":0,"showCount":0,"id":13618},{"addr":"fangshan广阳新路9号院1号楼中粮万科半岛购物广场3层","nm":"幸福蓝海国际影城(北京房山店)","ct":"","deal":1,"dis":"","brd":"幸福蓝海国际影城","distance":0,"follow":0,"imax":0,"sellPrice":35,"poiId":40470614,"lat":39.753548,"lng":116.21099,"sell":true,"sellmin":0,"preferential":0,"area":"fangshan","brdId":30053,"dealPrice":33,"referencePrice":0,"showCount":0,"id":13028},{"addr":"fangshan良乡北关西路14号华冠购物中心五层","nm":"新华国际影城(房山店)","ct":"","deal":0,"dis":"房山","brd":"新华国际影城","distance":0,"follow":0,"imax":0,"sellPrice":38,"poiId":299222,"lat":39.73469,"lng":116.13953,"sell":true,"sellmin":0,"preferential":0,"area":"fangshan","brdId":29894,"dealPrice":0,"referencePrice":60,"showCount":0,"id":131},{"addr":"fangshan燕山岗南路3号","nm":"燕山影剧院","ct":"","deal":1,"dis":"房山","brd":"燕山影剧院","distance":0,"follow":0,"imax":0,"sellPrice":33,"poiId":271449,"lat":39.72787,"lng":115.96215,"sell":true,"sellmin":0,"preferential":0,"area":"fangshan","brdId":777439,"dealPrice":35,"referencePrice":35,"showCount":0,"id":60},{"addr":"fangshan迎风街道岗南路9号","nm":"北京燕山文化活动中心影院","ct":"","deal":0,"dis":"","brd":"其它","distance":0,"follow":0,"imax":0,"sellPrice":0,"poiId":99082156,"lat":39.72558,"lng":115.96181,"sell":false,"sellmin":0,"preferential":0,"area":"fangshan","brdId":0,"dealPrice":0,"referencePrice":0,"showCount":0,"id":15272},{"addr":"fangshan兴房大街38号华冠欢乐城四楼","nm":"环球国际影城","ct":"","deal":1,"dis":"","brd":"其它","distance":0,"follow":0,"imax":0,"sellPrice":38,"poiId":5252975,"lat":39.69285,"lng":115.98708,"sell":false,"sellmin":0,"preferential":0,"area":"fangshan","brdId":0,"dealPrice":26,"referencePrice":0,"showCount":0,"id":9370},{"addr":"fangshan良乡拱辰大街31号","nm":"良乡影剧院","ct":"","deal":0,"dis":"房山","brd":"良乡影剧院","distance":0,"follow":0,"imax":0,"sellPrice":0,"poiId":1436368,"lat":39.73799,"lng":116.141685,"sell":false,"sellmin":0,"preferential":0,"area":"fangshan","brdId":949172,"dealPrice":0,"referencePrice":30,"showCount":0,"id":145}],"shunyi":[{"addr":"shunyi新顺南大街8号华联购物中心4层CGV星聚汇国际影城","nm":"CGV星聚汇影城(顺义店)","ct":"","deal":0,"dis":"","brd":"CGV星聚汇影城","distance":0,"follow":0,"imax":0,"sellPrice":33,"poiId":6448554,"lat":40.12897,"lng":116.65173,"sell":true,"sellmin":0,"preferential":0,"area":"shunyi","brdId":2020418,"dealPrice":0,"referencePrice":0,"showCount":0,"id":8111},{"addr":"shunyi新顺南大街18号新世界百货七层","nm":"博纳国际影城(顺义店)","ct":"","deal":0,"dis":"顺义","brd":"博纳国际影城","distance":0,"follow":0,"imax":0,"sellPrice":29,"poiId":1437402,"lat":40.126575,"lng":116.65212,"sell":true,"sellmin":0,"preferential":0,"area":"shunyi","brdId":24595,"dealPrice":0,"referencePrice":70,"showCount":0,"id":69},{"addr":"shunyi安泰大街9号院7号楼二层（祥云小镇内）","nm":"橙天嘉禾影城(祥云小镇店)","ct":"","deal":0,"dis":"","brd":"橙天嘉禾影城","distance":0,"follow":0,"imax":0,"sellPrice":33.5,"poiId":40420215,"lat":40.09027,"lng":116.53684,"sell":true,"sellmin":0,"preferential":0,"area":"shunyi","brdId":24745,"dealPrice":0,"referencePrice":0,"showCount":0,"id":11102},{"addr":"shunyi新顺南大街11号隆华购物中心6F","nm":"大地影院(顺义隆华店)","ct":"","deal":1,"dis":"","brd":"大地影院","distance":0,"follow":0,"imax":0,"sellPrice":33,"poiId":41599879,"lat":40.125973,"lng":116.650536,"sell":true,"sellmin":0,"preferential":0,"area":"shunyi","brdId":384262,"dealPrice":40.5,"referencePrice":0,"showCount":0,"id":12394},{"addr":"shunyi新顺北大街3号","nm":"顺义影剧院","ct":"","deal":1,"dis":"顺义","brd":"顺义影剧院","distance":0,"follow":0,"imax":0,"sellPrice":33,"poiId":89018,"lat":40.1338,"lng":116.650375,"sell":true,"sellmin":0,"preferential":0,"area":"shunyi","brdId":1148935,"dealPrice":25,"referencePrice":30,"showCount":0,"id":180}],"mentougou":[{"addr":"mentougou新桥大街12号","nm":"门头沟影剧院","ct":"","deal":0,"dis":"门头沟","brd":"其它","distance":0,"follow":0,"imax":0,"sellPrice":33,"poiId":3260641,"lat":39.9425,"lng":116.10049,"sell":true,"sellmin":0,"preferential":0,"area":"mentougou","brdId":0,"dealPrice":0,"referencePrice":0,"showCount":0,"id":182},{"addr":"mentougou永定镇冯村华润购物中心2层","nm":"幸福蓝海影城(门头沟店)","ct":"","deal":1,"dis":"","brd":"幸福蓝海国际影城","distance":0,"follow":0,"imax":0,"sellPrice":43,"poiId":42297501,"lat":39.91212,"lng":116.11124,"sell":true,"sellmin":0,"preferential":0,"area":"mentougou","brdId":30053,"dealPrice":35.9,"referencePrice":0,"showCount":0,"id":10570},{"addr":"mentougou双峪路35号熙旺生活广场B座6层","nm":"熙旺国际影城","ct":"","deal":1,"dis":"","brd":"其它","distance":0,"follow":0,"imax":0,"sellPrice":43,"poiId":40550440,"lat":39.93551,"lng":116.11315,"sell":true,"sellmin":0,"preferential":0,"area":"mentougou","brdId":0,"dealPrice":35.9,"referencePrice":0,"showCount":0,"id":10979}],"shijingshan":[{"addr":"shijingshan阜石路300号喜隆多三层","nm":"保利国际影城(苹果园店)","ct":"","deal":0,"dis":"","brd":"保利国际影城","distance":0,"follow":0,"imax":0,"sellPrice":43,"poiId":6596632,"lat":39.92295,"lng":116.17175,"sell":true,"sellmin":0,"preferential":0,"area":"shijingshan","brdId":24472,"dealPrice":0,"referencePrice":0,"showCount":0,"id":10294},{"addr":"shijingshan古城南路15号","nm":"古城电影院","ct":"","deal":1,"dis":"古城","brd":"古城电影院","distance":0,"follow":0,"imax":0,"sellPrice":28,"poiId":82589,"lat":39.9112,"lng":116.19126,"sell":true,"sellmin":0,"preferential":0,"area":"shijingshan","brdId":302869,"dealPrice":30,"referencePrice":0,"showCount":0,"id":246},{"addr":"shijingshan石景山路乙18号万达广场娱乐楼4楼","nm":"万达国际影城(石景山店)","ct":"","deal":0,"dis":"鲁谷","brd":"万达影城","distance":0,"follow":0,"imax":1,"sellPrice":43,"poiId":298683,"lat":39.905945,"lng":116.22568,"sell":true,"sellmin":0,"preferential":0,"area":"shijingshan","brdId":102642,"dealPrice":0,"referencePrice":80,"showCount":0,"id":133}],"huairou":[{"addr":"huairou青春路15号四层","nm":"传奇瑞丽影城","ct":"","deal":0,"dis":"怀柔","brd":"其它","distance":0,"follow":0,"imax":0,"sellPrice":43,"poiId":3260663,"lat":40.317955,"lng":116.62985,"sell":true,"sellmin":0,"preferential":0,"area":"huairou","brdId":0,"dealPrice":0,"referencePrice":35,"showCount":0,"id":55},{"addr":"huairou富乐大街8号","nm":"huairou电影院","ct":"","deal":0,"dis":"怀柔","brd":"其它","distance":0,"follow":0,"imax":0,"sellPrice":0,"poiId":1541434,"lat":40.34083,"lng":116.64014,"sell":false,"sellmin":0,"preferential":0,"area":"huairou","brdId":0,"dealPrice":0,"referencePrice":0,"showCount":0,"id":2378},{"addr":"huairou雁栖湖路1号","nm":"米珈尼汽车影院","ct":"","deal":0,"dis":"","brd":"其它","distance":0,"follow":0,"imax":0,"sellPrice":0,"poiId":94728699,"lat":40.392265,"lng":116.67963,"sell":false,"sellmin":0,"preferential":0,"area":"huairou","brdId":0,"dealPrice":0,"referencePrice":0,"showCount":0,"id":15748}],"pinggu":[{"addr":"pinggu迎宾路1号院22号楼五层F5-13","nm":"耀莱成龙国际影城(平谷店)","ct":"","deal":0,"dis":"","brd":"耀莱成龙国际影城","distance":0,"follow":0,"imax":0,"sellPrice":38,"poiId":97314976,"lat":40.14356,"lng":117.093155,"sell":true,"sellmin":0,"preferential":0,"area":"pinggu","brdId":30227,"dealPrice":0,"referencePrice":0,"showCount":0,"id":15082},{"addr":"pinggu府前街3号","nm":"pinggu影剧院","ct":"","deal":0,"dis":"平谷","brd":"pinggu影剧院","distance":0,"follow":0,"imax":0,"sellPrice":0,"poiId":1156598,"lat":40.14054,"lng":117.1224,"sell":false,"sellmin":0,"preferential":0,"area":"pinggu","brdId":505125,"dealPrice":0,"referencePrice":0,"showCount":0,"id":2379}],"miyun":[{"addr":"miyun鼓楼西大街1号","nm":"密云大剧院","ct":"","deal":0,"dis":"miyun","brd":"其它","distance":0,"follow":0,"imax":0,"sellPrice":33,"poiId":1436412,"lat":40.377117,"lng":116.84507,"sell":true,"sellmin":0,"preferential":0,"area":"miyun","brdId":0,"dealPrice":0,"referencePrice":60,"showCount":0,"id":183}],"yanqing":[{"addr":"yanqing妫水北街39号1幢H座首楼金锣湾商业中心沃尔玛旁","nm":"大地影院(延庆金锣湾店)","ct":"","deal":1,"dis":"延庆","brd":"大地影院","distance":0,"follow":0,"imax":0,"sellPrice":38,"poiId":1366944,"lat":40.461918,"lng":115.97629,"sell":true,"sellmin":0,"preferential":0,"area":"yanqing","brdId":384262,"dealPrice":39,"referencePrice":40,"showCount":0,"id":13}]}
     */

    private int status;
    private DataBean data;

    public ControlBean getControl() {
        return control;
    }

    public void setControl(ControlBean control) {
        this.control = control;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class ControlBean {
        private int expires;

        public int getExpires() {
            return expires;
        }

        public void setExpires(int expires) {
            this.expires = expires;
        }
    }

    public static class DataBean {
        /**
         * addr : chaoyang京顺路111号比如世界购物中心1层（近太阳宫北街）
         * nm : 17.5影城(比如世界店)
         * ct : 
         * deal : 0
         * dis : 望京
         * brd : 17.5影城
         * distance : 0
         * follow : 0
         * imax : 0
         * sellPrice : 22
         * poiId : 75603
         * lat : 39.9684
         * lng : 116.46204
         * sell : true
         * sellmin : 0
         * preferential : 0
         * area : chaoyang
         * brdId : 23854
         * dealPrice : 0
         * referencePrice : 70
         * showCount : 0
         * id : 48
         */

        private List<chaoyangBean> chaoyang;
        /**
         * addr : haidian文慧园路9号今典花园9号楼空间蒙太奇大厦1层
         * nm : 17.5影城(今典花园店)
         * ct : 
         * deal : 1
         * dis : 北太平庄
         * brd : 17.5影城
         * distance : 0
         * follow : 0
         * imax : 0
         * sellPrice : 27
         * poiId : 273950
         * lat : 39.95334
         * lng : 116.36104
         * sell : true
         * sellmin : 0
         * preferential : 0
         * area : haidian
         * brdId : 23854
         * dealPrice : 30
         * referencePrice : 60
         * showCount : 0
         * id : 154
         */

        private List<haidianBean> haidian;
        /**
         * addr : dongcheng北三环安贞桥环球贸易中心E座
         * nm : UME国际影城(安贞店)
         * ct : 
         * deal : 0
         * dis : 安贞
         * brd : UME国际影城
         * distance : 0
         * follow : 0
         * imax : 0
         * sellPrice : 39.5
         * poiId : 94496
         * lat : 39.966072
         * lng : 116.41096
         * sell : true
         * sellmin : 0
         * preferential : 0
         * area : dongcheng
         * brdId : 24071
         * dealPrice : 0
         * referencePrice : 70
         * showCount : 0
         * id : 99
         */

        private List<dongchengBean> dongcheng;
        /**
         * addr : fengtai南三环西路16号凯德大峡谷购物中心5楼
         * nm : 保利国际影城(凯德MALL·大峡谷店)
         * ct : 
         * deal : 0
         * dis : 草桥
         * brd : 保利国际影城
         * distance : 0
         * follow : 0
         * imax : 0
         * sellPrice : 39
         * poiId : 339944
         * lat : 39.854645
         * lng : 116.36706
         * sell : true
         * sellmin : 0
         * preferential : 0
         * area : fengtai
         * brdId : 24472
         * dealPrice : 0
         * referencePrice : 40
         * showCount : 0
         * id : 42
         */

        private List<fengtaiBean> fengtai;
        /**
         * addr : daxing金星西路3号绿地缤纷城购物中心4层
         * nm : 保利国际影城(绿地缤纷城店)
         * ct : 
         * deal : 0
         * dis : 绿地缤纷城
         * brd : 保利国际影城
         * distance : 0
         * follow : 0
         * imax : 0
         * sellPrice : 39
         * poiId : 1481117
         * lat : 39.764683
         * lng : 116.33354
         * sell : true
         * sellmin : 0
         * preferential : 0
         * area : daxing
         * brdId : 24472
         * dealPrice : 0
         * referencePrice : 70
         * showCount : 0
         * id : 2392
         */

        private List<daxingBean> daxing;
        /**
         * addr : xicheng西直门南小街68号
         * nm : 北京青年宫
         * ct : 
         * deal : 0
         * dis : 西直门
         * brd : 其它
         * distance : 0
         * follow : 0
         * imax : 0
         * sellPrice : 38
         * poiId : 271434
         * lat : 39.93531
         * lng : 116.35955
         * sell : true
         * sellmin : 0
         * preferential : 0
         * area : xicheng
         * brdId : 0
         * dealPrice : 0
         * referencePrice : 50
         * showCount : 0
         * id : 260
         */

        private List<xichengBean> xicheng;
        /**
         * addr : tongzhou杨庄北里52号华联天时名苑购物中心4楼（近通州北苑地铁站）
         * nm : 博纳国际影城(通州北苑店)
         * ct : 
         * deal : 0
         * dis : 新华联
         * brd : 博纳国际影城
         * distance : 0
         * follow : 0
         * imax : 0
         * sellPrice : 39
         * poiId : 363447
         * lat : 39.903496
         * lng : 116.6367
         * sell : true
         * sellmin : 0
         * preferential : 0
         * area : tongzhou
         * brdId : 24595
         * dealPrice : 0
         * referencePrice : 80
         * showCount : 0
         * id : 2
         */

        private List<tongzhouBean> tongzhou;
        /**
         * addr : changping黄平路19号院3号楼龙旗广场购物中心3层（地铁8号线育新站路北600米，近永辉超市）
         * nm : 保利国际影城(龙旗广场店)
         * ct : 
         * deal : 1
         * dis : 回龙观
         * brd : 保利国际影城
         * distance : 0
         * follow : 0
         * imax : 0
         * sellPrice : 39
         * poiId : 3320660
         * lat : 40.066605
         * lng : 116.34672
         * sell : true
         * sellmin : 0
         * preferential : 0
         * area : changping
         * brdId : 24472
         * dealPrice : 40
         * referencePrice : 100
         * showCount : 0
         * id : 5502
         */

        private List<changpingBean> changping;
        /**
         * addr : fangshan黄辛庄路口绿地缤纷城3层
         * nm : SFC上影(房山店)
         * ct : 
         * deal : 0
         * dis : 
         * brd : 其它
         * distance : 0
         * follow : 0
         * imax : 0
         * sellPrice : 38
         * poiId : 52294367
         * lat : 39.756683
         * lng : 116.160515
         * sell : true
         * sellmin : 0
         * preferential : 0
         * area : fangshan
         * brdId : 0
         * dealPrice : 0
         * referencePrice : 0
         * showCount : 0
         * id : 13618
         */

        private List<fangshanBean> fangshan;
        /**
         * addr : shunyi新顺南大街8号华联购物中心4层CGV星聚汇国际影城
         * nm : CGV星聚汇影城(顺义店)
         * ct : 
         * deal : 0
         * dis : 
         * brd : CGV星聚汇影城
         * distance : 0
         * follow : 0
         * imax : 0
         * sellPrice : 33
         * poiId : 6448554
         * lat : 40.12897
         * lng : 116.65173
         * sell : true
         * sellmin : 0
         * preferential : 0
         * area : shunyi
         * brdId : 2020418
         * dealPrice : 0
         * referencePrice : 0
         * showCount : 0
         * id : 8111
         */

        private List<shunyiBean> shunyi;
        /**
         * addr : mentougou新桥大街12号
         * nm : 门头沟影剧院
         * ct : 
         * deal : 0
         * dis : 门头沟
         * brd : 其它
         * distance : 0
         * follow : 0
         * imax : 0
         * sellPrice : 33
         * poiId : 3260641
         * lat : 39.9425
         * lng : 116.10049
         * sell : true
         * sellmin : 0
         * preferential : 0
         * area : mentougou
         * brdId : 0
         * dealPrice : 0
         * referencePrice : 0
         * showCount : 0
         * id : 182
         */

        private List<mentougouBean> mentougou;
        /**
         * addr : shijingshan阜石路300号喜隆多三层
         * nm : 保利国际影城(苹果园店)
         * ct : 
         * deal : 0
         * dis : 
         * brd : 保利国际影城
         * distance : 0
         * follow : 0
         * imax : 0
         * sellPrice : 43
         * poiId : 6596632
         * lat : 39.92295
         * lng : 116.17175
         * sell : true
         * sellmin : 0
         * preferential : 0
         * area : shijingshan
         * brdId : 24472
         * dealPrice : 0
         * referencePrice : 0
         * showCount : 0
         * id : 10294
         */

        private List<shijingshanBean> shijingshan;
        /**
         * addr : huairou青春路15号四层
         * nm : 传奇瑞丽影城
         * ct : 
         * deal : 0
         * dis : 怀柔
         * brd : 其它
         * distance : 0
         * follow : 0
         * imax : 0
         * sellPrice : 43
         * poiId : 3260663
         * lat : 40.317955
         * lng : 116.62985
         * sell : true
         * sellmin : 0
         * preferential : 0
         * area : huairou
         * brdId : 0
         * dealPrice : 0
         * referencePrice : 35
         * showCount : 0
         * id : 55
         */

        private List<huairouBean> huairou;
        /**
         * addr : pinggu迎宾路1号院22号楼五层F5-13
         * nm : 耀莱成龙国际影城(平谷店)
         * ct : 
         * deal : 0
         * dis : 
         * brd : 耀莱成龙国际影城
         * distance : 0
         * follow : 0
         * imax : 0
         * sellPrice : 38
         * poiId : 97314976
         * lat : 40.14356
         * lng : 117.093155
         * sell : true
         * sellmin : 0
         * preferential : 0
         * area : pinggu
         * brdId : 30227
         * dealPrice : 0
         * referencePrice : 0
         * showCount : 0
         * id : 15082
         */

        private List<pingguBean> pinggu;
        /**
         * addr : miyun鼓楼西大街1号
         * nm : 密云大剧院
         * ct : 
         * deal : 0
         * dis : miyun
         * brd : 其它
         * distance : 0
         * follow : 0
         * imax : 0
         * sellPrice : 33
         * poiId : 1436412
         * lat : 40.377117
         * lng : 116.84507
         * sell : true
         * sellmin : 0
         * preferential : 0
         * area : miyun
         * brdId : 0
         * dealPrice : 0
         * referencePrice : 60
         * showCount : 0
         * id : 183
         */

        private List<miyunBean> miyun;
        /**
         * addr : yanqing妫水北街39号1幢H座首楼金锣湾商业中心沃尔玛旁
         * nm : 大地影院(延庆金锣湾店)
         * ct : 
         * deal : 1
         * dis : 延庆
         * brd : 大地影院
         * distance : 0
         * follow : 0
         * imax : 0
         * sellPrice : 38
         * poiId : 1366944
         * lat : 40.461918
         * lng : 115.97629
         * sell : true
         * sellmin : 0
         * preferential : 0
         * area : yanqing
         * brdId : 384262
         * dealPrice : 39
         * referencePrice : 40
         * showCount : 0
         * id : 13
         */

        private List<yanqingBean> yanqing;

        public List<chaoyangBean> getchaoyang() {
            return chaoyang;
        }

        public void setchaoyang(List<chaoyangBean> chaoyang) {
            this.chaoyang = chaoyang;
        }

        public List<haidianBean> gethaidian() {
            return haidian;
        }

        public void sethaidian(List<haidianBean> haidian) {
            this.haidian = haidian;
        }

        public List<dongchengBean> getdongcheng() {
            return dongcheng;
        }

        public void setdongcheng(List<dongchengBean> dongcheng) {
            this.dongcheng = dongcheng;
        }

        public List<fengtaiBean> getfengtai() {
            return fengtai;
        }

        public void setfengtai(List<fengtaiBean> fengtai) {
            this.fengtai = fengtai;
        }

        public List<daxingBean> getdaxing() {
            return daxing;
        }

        public void setdaxing(List<daxingBean> daxing) {
            this.daxing = daxing;
        }

        public List<xichengBean> getxicheng() {
            return xicheng;
        }

        public void setxicheng(List<xichengBean> xicheng) {
            this.xicheng = xicheng;
        }

        public List<tongzhouBean> gettongzhou() {
            return tongzhou;
        }

        public void settongzhou(List<tongzhouBean> tongzhou) {
            this.tongzhou = tongzhou;
        }

        public List<changpingBean> getchangping() {
            return changping;
        }

        public void setchangping(List<changpingBean> changping) {
            this.changping = changping;
        }

        public List<fangshanBean> getfangshan() {
            return fangshan;
        }

        public void setfangshan(List<fangshanBean> fangshan) {
            this.fangshan = fangshan;
        }

        public List<shunyiBean> getshunyi() {
            return shunyi;
        }

        public void setshunyi(List<shunyiBean> shunyi) {
            this.shunyi = shunyi;
        }

        public List<mentougouBean> getmentougou() {
            return mentougou;
        }

        public void setmentougou(List<mentougouBean> mentougou) {
            this.mentougou = mentougou;
        }

        public List<shijingshanBean> getshijingshan() {
            return shijingshan;
        }

        public void setshijingshan(List<shijingshanBean> shijingshan) {
            this.shijingshan = shijingshan;
        }

        public List<huairouBean> gethuairou() {
            return huairou;
        }

        public void sethuairou(List<huairouBean> huairou) {
            this.huairou = huairou;
        }

        public List<pingguBean> getpinggu() {
            return pinggu;
        }

        public void setpinggu(List<pingguBean> pinggu) {
            this.pinggu = pinggu;
        }

        public List<miyunBean> getmiyun() {
            return miyun;
        }

        public void setmiyun(List<miyunBean> miyun) {
            this.miyun = miyun;
        }

        public List<yanqingBean> getyanqing() {
            return yanqing;
        }

        public void setyanqing(List<yanqingBean> yanqing) {
            this.yanqing = yanqing;
        }

        public static class chaoyangBean {
            private String addr;
            private String nm;
            private String ct;
            private int deal;
            private String dis;
            private String brd;
            private int distance;
            private int follow;
            private int imax;
            private int sellPrice;
            private int poiId;
            private double lat;
            private double lng;
            private boolean sell;
            private int sellmin;
            private int preferential;
            private String area;
            private int brdId;
            private int dealPrice;
            private int referencePrice;
            private int showCount;
            private int id;

            public String getAddr() {
                return addr;
            }

            public void setAddr(String addr) {
                this.addr = addr;
            }

            public String getNm() {
                return nm;
            }

            public void setNm(String nm) {
                this.nm = nm;
            }

            public String getCt() {
                return ct;
            }

            public void setCt(String ct) {
                this.ct = ct;
            }

            public int getDeal() {
                return deal;
            }

            public void setDeal(int deal) {
                this.deal = deal;
            }

            public String getDis() {
                return dis;
            }

            public void setDis(String dis) {
                this.dis = dis;
            }

            public String getBrd() {
                return brd;
            }

            public void setBrd(String brd) {
                this.brd = brd;
            }

            public int getDistance() {
                return distance;
            }

            public void setDistance(int distance) {
                this.distance = distance;
            }

            public int getFollow() {
                return follow;
            }

            public void setFollow(int follow) {
                this.follow = follow;
            }

            public int getImax() {
                return imax;
            }

            public void setImax(int imax) {
                this.imax = imax;
            }

            public int getSellPrice() {
                return sellPrice;
            }

            public void setSellPrice(int sellPrice) {
                this.sellPrice = sellPrice;
            }

            public int getPoiId() {
                return poiId;
            }

            public void setPoiId(int poiId) {
                this.poiId = poiId;
            }

            public double getLat() {
                return lat;
            }

            public void setLat(double lat) {
                this.lat = lat;
            }

            public double getLng() {
                return lng;
            }

            public void setLng(double lng) {
                this.lng = lng;
            }

            public boolean isSell() {
                return sell;
            }

            public void setSell(boolean sell) {
                this.sell = sell;
            }

            public int getSellmin() {
                return sellmin;
            }

            public void setSellmin(int sellmin) {
                this.sellmin = sellmin;
            }

            public int getPreferential() {
                return preferential;
            }

            public void setPreferential(int preferential) {
                this.preferential = preferential;
            }

            public String getArea() {
                return area;
            }

            public void setArea(String area) {
                this.area = area;
            }

            public int getBrdId() {
                return brdId;
            }

            public void setBrdId(int brdId) {
                this.brdId = brdId;
            }

            public int getDealPrice() {
                return dealPrice;
            }

            public void setDealPrice(int dealPrice) {
                this.dealPrice = dealPrice;
            }

            public int getReferencePrice() {
                return referencePrice;
            }

            public void setReferencePrice(int referencePrice) {
                this.referencePrice = referencePrice;
            }

            public int getShowCount() {
                return showCount;
            }

            public void setShowCount(int showCount) {
                this.showCount = showCount;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }
        }

        public static class haidianBean {
            private String addr;
            private String nm;
            private String ct;
            private int deal;
            private String dis;
            private String brd;
            private int distance;
            private int follow;
            private int imax;
            private int sellPrice;
            private int poiId;
            private double lat;
            private double lng;
            private boolean sell;
            private int sellmin;
            private int preferential;
            private String area;
            private int brdId;
            private int dealPrice;
            private int referencePrice;
            private int showCount;
            private int id;

            public String getAddr() {
                return addr;
            }

            public void setAddr(String addr) {
                this.addr = addr;
            }

            public String getNm() {
                return nm;
            }

            public void setNm(String nm) {
                this.nm = nm;
            }

            public String getCt() {
                return ct;
            }

            public void setCt(String ct) {
                this.ct = ct;
            }

            public int getDeal() {
                return deal;
            }

            public void setDeal(int deal) {
                this.deal = deal;
            }

            public String getDis() {
                return dis;
            }

            public void setDis(String dis) {
                this.dis = dis;
            }

            public String getBrd() {
                return brd;
            }

            public void setBrd(String brd) {
                this.brd = brd;
            }

            public int getDistance() {
                return distance;
            }

            public void setDistance(int distance) {
                this.distance = distance;
            }

            public int getFollow() {
                return follow;
            }

            public void setFollow(int follow) {
                this.follow = follow;
            }

            public int getImax() {
                return imax;
            }

            public void setImax(int imax) {
                this.imax = imax;
            }

            public int getSellPrice() {
                return sellPrice;
            }

            public void setSellPrice(int sellPrice) {
                this.sellPrice = sellPrice;
            }

            public int getPoiId() {
                return poiId;
            }

            public void setPoiId(int poiId) {
                this.poiId = poiId;
            }

            public double getLat() {
                return lat;
            }

            public void setLat(double lat) {
                this.lat = lat;
            }

            public double getLng() {
                return lng;
            }

            public void setLng(double lng) {
                this.lng = lng;
            }

            public boolean isSell() {
                return sell;
            }

            public void setSell(boolean sell) {
                this.sell = sell;
            }

            public int getSellmin() {
                return sellmin;
            }

            public void setSellmin(int sellmin) {
                this.sellmin = sellmin;
            }

            public int getPreferential() {
                return preferential;
            }

            public void setPreferential(int preferential) {
                this.preferential = preferential;
            }

            public String getArea() {
                return area;
            }

            public void setArea(String area) {
                this.area = area;
            }

            public int getBrdId() {
                return brdId;
            }

            public void setBrdId(int brdId) {
                this.brdId = brdId;
            }

            public int getDealPrice() {
                return dealPrice;
            }

            public void setDealPrice(int dealPrice) {
                this.dealPrice = dealPrice;
            }

            public int getReferencePrice() {
                return referencePrice;
            }

            public void setReferencePrice(int referencePrice) {
                this.referencePrice = referencePrice;
            }

            public int getShowCount() {
                return showCount;
            }

            public void setShowCount(int showCount) {
                this.showCount = showCount;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }
        }

        public static class dongchengBean {
            private String addr;
            private String nm;
            private String ct;
            private int deal;
            private String dis;
            private String brd;
            private int distance;
            private int follow;
            private int imax;
            private double sellPrice;
            private int poiId;
            private double lat;
            private double lng;
            private boolean sell;
            private int sellmin;
            private int preferential;
            private String area;
            private int brdId;
            private int dealPrice;
            private int referencePrice;
            private int showCount;
            private int id;

            public String getAddr() {
                return addr;
            }

            public void setAddr(String addr) {
                this.addr = addr;
            }

            public String getNm() {
                return nm;
            }

            public void setNm(String nm) {
                this.nm = nm;
            }

            public String getCt() {
                return ct;
            }

            public void setCt(String ct) {
                this.ct = ct;
            }

            public int getDeal() {
                return deal;
            }

            public void setDeal(int deal) {
                this.deal = deal;
            }

            public String getDis() {
                return dis;
            }

            public void setDis(String dis) {
                this.dis = dis;
            }

            public String getBrd() {
                return brd;
            }

            public void setBrd(String brd) {
                this.brd = brd;
            }

            public int getDistance() {
                return distance;
            }

            public void setDistance(int distance) {
                this.distance = distance;
            }

            public int getFollow() {
                return follow;
            }

            public void setFollow(int follow) {
                this.follow = follow;
            }

            public int getImax() {
                return imax;
            }

            public void setImax(int imax) {
                this.imax = imax;
            }

            public double getSellPrice() {
                return sellPrice;
            }

            public void setSellPrice(double sellPrice) {
                this.sellPrice = sellPrice;
            }

            public int getPoiId() {
                return poiId;
            }

            public void setPoiId(int poiId) {
                this.poiId = poiId;
            }

            public double getLat() {
                return lat;
            }

            public void setLat(double lat) {
                this.lat = lat;
            }

            public double getLng() {
                return lng;
            }

            public void setLng(double lng) {
                this.lng = lng;
            }

            public boolean isSell() {
                return sell;
            }

            public void setSell(boolean sell) {
                this.sell = sell;
            }

            public int getSellmin() {
                return sellmin;
            }

            public void setSellmin(int sellmin) {
                this.sellmin = sellmin;
            }

            public int getPreferential() {
                return preferential;
            }

            public void setPreferential(int preferential) {
                this.preferential = preferential;
            }

            public String getArea() {
                return area;
            }

            public void setArea(String area) {
                this.area = area;
            }

            public int getBrdId() {
                return brdId;
            }

            public void setBrdId(int brdId) {
                this.brdId = brdId;
            }

            public int getDealPrice() {
                return dealPrice;
            }

            public void setDealPrice(int dealPrice) {
                this.dealPrice = dealPrice;
            }

            public int getReferencePrice() {
                return referencePrice;
            }

            public void setReferencePrice(int referencePrice) {
                this.referencePrice = referencePrice;
            }

            public int getShowCount() {
                return showCount;
            }

            public void setShowCount(int showCount) {
                this.showCount = showCount;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }
        }

        public static class fengtaiBean {
            private String addr;
            private String nm;
            private String ct;
            private int deal;
            private String dis;
            private String brd;
            private int distance;
            private int follow;
            private int imax;
            private int sellPrice;
            private int poiId;
            private double lat;
            private double lng;
            private boolean sell;
            private int sellmin;
            private int preferential;
            private String area;
            private int brdId;
            private int dealPrice;
            private int referencePrice;
            private int showCount;
            private int id;

            public String getAddr() {
                return addr;
            }

            public void setAddr(String addr) {
                this.addr = addr;
            }

            public String getNm() {
                return nm;
            }

            public void setNm(String nm) {
                this.nm = nm;
            }

            public String getCt() {
                return ct;
            }

            public void setCt(String ct) {
                this.ct = ct;
            }

            public int getDeal() {
                return deal;
            }

            public void setDeal(int deal) {
                this.deal = deal;
            }

            public String getDis() {
                return dis;
            }

            public void setDis(String dis) {
                this.dis = dis;
            }

            public String getBrd() {
                return brd;
            }

            public void setBrd(String brd) {
                this.brd = brd;
            }

            public int getDistance() {
                return distance;
            }

            public void setDistance(int distance) {
                this.distance = distance;
            }

            public int getFollow() {
                return follow;
            }

            public void setFollow(int follow) {
                this.follow = follow;
            }

            public int getImax() {
                return imax;
            }

            public void setImax(int imax) {
                this.imax = imax;
            }

            public int getSellPrice() {
                return sellPrice;
            }

            public void setSellPrice(int sellPrice) {
                this.sellPrice = sellPrice;
            }

            public int getPoiId() {
                return poiId;
            }

            public void setPoiId(int poiId) {
                this.poiId = poiId;
            }

            public double getLat() {
                return lat;
            }

            public void setLat(double lat) {
                this.lat = lat;
            }

            public double getLng() {
                return lng;
            }

            public void setLng(double lng) {
                this.lng = lng;
            }

            public boolean isSell() {
                return sell;
            }

            public void setSell(boolean sell) {
                this.sell = sell;
            }

            public int getSellmin() {
                return sellmin;
            }

            public void setSellmin(int sellmin) {
                this.sellmin = sellmin;
            }

            public int getPreferential() {
                return preferential;
            }

            public void setPreferential(int preferential) {
                this.preferential = preferential;
            }

            public String getArea() {
                return area;
            }

            public void setArea(String area) {
                this.area = area;
            }

            public int getBrdId() {
                return brdId;
            }

            public void setBrdId(int brdId) {
                this.brdId = brdId;
            }

            public int getDealPrice() {
                return dealPrice;
            }

            public void setDealPrice(int dealPrice) {
                this.dealPrice = dealPrice;
            }

            public int getReferencePrice() {
                return referencePrice;
            }

            public void setReferencePrice(int referencePrice) {
                this.referencePrice = referencePrice;
            }

            public int getShowCount() {
                return showCount;
            }

            public void setShowCount(int showCount) {
                this.showCount = showCount;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }
        }

        public static class daxingBean {
            private String addr;
            private String nm;
            private String ct;
            private int deal;
            private String dis;
            private String brd;
            private int distance;
            private int follow;
            private int imax;
            private int sellPrice;
            private int poiId;
            private double lat;
            private double lng;
            private boolean sell;
            private int sellmin;
            private int preferential;
            private String area;
            private int brdId;
            private int dealPrice;
            private int referencePrice;
            private int showCount;
            private int id;

            public String getAddr() {
                return addr;
            }

            public void setAddr(String addr) {
                this.addr = addr;
            }

            public String getNm() {
                return nm;
            }

            public void setNm(String nm) {
                this.nm = nm;
            }

            public String getCt() {
                return ct;
            }

            public void setCt(String ct) {
                this.ct = ct;
            }

            public int getDeal() {
                return deal;
            }

            public void setDeal(int deal) {
                this.deal = deal;
            }

            public String getDis() {
                return dis;
            }

            public void setDis(String dis) {
                this.dis = dis;
            }

            public String getBrd() {
                return brd;
            }

            public void setBrd(String brd) {
                this.brd = brd;
            }

            public int getDistance() {
                return distance;
            }

            public void setDistance(int distance) {
                this.distance = distance;
            }

            public int getFollow() {
                return follow;
            }

            public void setFollow(int follow) {
                this.follow = follow;
            }

            public int getImax() {
                return imax;
            }

            public void setImax(int imax) {
                this.imax = imax;
            }

            public int getSellPrice() {
                return sellPrice;
            }

            public void setSellPrice(int sellPrice) {
                this.sellPrice = sellPrice;
            }

            public int getPoiId() {
                return poiId;
            }

            public void setPoiId(int poiId) {
                this.poiId = poiId;
            }

            public double getLat() {
                return lat;
            }

            public void setLat(double lat) {
                this.lat = lat;
            }

            public double getLng() {
                return lng;
            }

            public void setLng(double lng) {
                this.lng = lng;
            }

            public boolean isSell() {
                return sell;
            }

            public void setSell(boolean sell) {
                this.sell = sell;
            }

            public int getSellmin() {
                return sellmin;
            }

            public void setSellmin(int sellmin) {
                this.sellmin = sellmin;
            }

            public int getPreferential() {
                return preferential;
            }

            public void setPreferential(int preferential) {
                this.preferential = preferential;
            }

            public String getArea() {
                return area;
            }

            public void setArea(String area) {
                this.area = area;
            }

            public int getBrdId() {
                return brdId;
            }

            public void setBrdId(int brdId) {
                this.brdId = brdId;
            }

            public int getDealPrice() {
                return dealPrice;
            }

            public void setDealPrice(int dealPrice) {
                this.dealPrice = dealPrice;
            }

            public int getReferencePrice() {
                return referencePrice;
            }

            public void setReferencePrice(int referencePrice) {
                this.referencePrice = referencePrice;
            }

            public int getShowCount() {
                return showCount;
            }

            public void setShowCount(int showCount) {
                this.showCount = showCount;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }
        }

        public static class xichengBean {
            private String addr;
            private String nm;
            private String ct;
            private int deal;
            private String dis;
            private String brd;
            private int distance;
            private int follow;
            private int imax;
            private int sellPrice;
            private int poiId;
            private double lat;
            private double lng;
            private boolean sell;
            private int sellmin;
            private int preferential;
            private String area;
            private int brdId;
            private int dealPrice;
            private int referencePrice;
            private int showCount;
            private int id;

            public String getAddr() {
                return addr;
            }

            public void setAddr(String addr) {
                this.addr = addr;
            }

            public String getNm() {
                return nm;
            }

            public void setNm(String nm) {
                this.nm = nm;
            }

            public String getCt() {
                return ct;
            }

            public void setCt(String ct) {
                this.ct = ct;
            }

            public int getDeal() {
                return deal;
            }

            public void setDeal(int deal) {
                this.deal = deal;
            }

            public String getDis() {
                return dis;
            }

            public void setDis(String dis) {
                this.dis = dis;
            }

            public String getBrd() {
                return brd;
            }

            public void setBrd(String brd) {
                this.brd = brd;
            }

            public int getDistance() {
                return distance;
            }

            public void setDistance(int distance) {
                this.distance = distance;
            }

            public int getFollow() {
                return follow;
            }

            public void setFollow(int follow) {
                this.follow = follow;
            }

            public int getImax() {
                return imax;
            }

            public void setImax(int imax) {
                this.imax = imax;
            }

            public int getSellPrice() {
                return sellPrice;
            }

            public void setSellPrice(int sellPrice) {
                this.sellPrice = sellPrice;
            }

            public int getPoiId() {
                return poiId;
            }

            public void setPoiId(int poiId) {
                this.poiId = poiId;
            }

            public double getLat() {
                return lat;
            }

            public void setLat(double lat) {
                this.lat = lat;
            }

            public double getLng() {
                return lng;
            }

            public void setLng(double lng) {
                this.lng = lng;
            }

            public boolean isSell() {
                return sell;
            }

            public void setSell(boolean sell) {
                this.sell = sell;
            }

            public int getSellmin() {
                return sellmin;
            }

            public void setSellmin(int sellmin) {
                this.sellmin = sellmin;
            }

            public int getPreferential() {
                return preferential;
            }

            public void setPreferential(int preferential) {
                this.preferential = preferential;
            }

            public String getArea() {
                return area;
            }

            public void setArea(String area) {
                this.area = area;
            }

            public int getBrdId() {
                return brdId;
            }

            public void setBrdId(int brdId) {
                this.brdId = brdId;
            }

            public int getDealPrice() {
                return dealPrice;
            }

            public void setDealPrice(int dealPrice) {
                this.dealPrice = dealPrice;
            }

            public int getReferencePrice() {
                return referencePrice;
            }

            public void setReferencePrice(int referencePrice) {
                this.referencePrice = referencePrice;
            }

            public int getShowCount() {
                return showCount;
            }

            public void setShowCount(int showCount) {
                this.showCount = showCount;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }
        }

        public static class tongzhouBean {
            private String addr;
            private String nm;
            private String ct;
            private int deal;
            private String dis;
            private String brd;
            private int distance;
            private int follow;
            private int imax;
            private int sellPrice;
            private int poiId;
            private double lat;
            private double lng;
            private boolean sell;
            private int sellmin;
            private int preferential;
            private String area;
            private int brdId;
            private int dealPrice;
            private int referencePrice;
            private int showCount;
            private int id;

            public String getAddr() {
                return addr;
            }

            public void setAddr(String addr) {
                this.addr = addr;
            }

            public String getNm() {
                return nm;
            }

            public void setNm(String nm) {
                this.nm = nm;
            }

            public String getCt() {
                return ct;
            }

            public void setCt(String ct) {
                this.ct = ct;
            }

            public int getDeal() {
                return deal;
            }

            public void setDeal(int deal) {
                this.deal = deal;
            }

            public String getDis() {
                return dis;
            }

            public void setDis(String dis) {
                this.dis = dis;
            }

            public String getBrd() {
                return brd;
            }

            public void setBrd(String brd) {
                this.brd = brd;
            }

            public int getDistance() {
                return distance;
            }

            public void setDistance(int distance) {
                this.distance = distance;
            }

            public int getFollow() {
                return follow;
            }

            public void setFollow(int follow) {
                this.follow = follow;
            }

            public int getImax() {
                return imax;
            }

            public void setImax(int imax) {
                this.imax = imax;
            }

            public int getSellPrice() {
                return sellPrice;
            }

            public void setSellPrice(int sellPrice) {
                this.sellPrice = sellPrice;
            }

            public int getPoiId() {
                return poiId;
            }

            public void setPoiId(int poiId) {
                this.poiId = poiId;
            }

            public double getLat() {
                return lat;
            }

            public void setLat(double lat) {
                this.lat = lat;
            }

            public double getLng() {
                return lng;
            }

            public void setLng(double lng) {
                this.lng = lng;
            }

            public boolean isSell() {
                return sell;
            }

            public void setSell(boolean sell) {
                this.sell = sell;
            }

            public int getSellmin() {
                return sellmin;
            }

            public void setSellmin(int sellmin) {
                this.sellmin = sellmin;
            }

            public int getPreferential() {
                return preferential;
            }

            public void setPreferential(int preferential) {
                this.preferential = preferential;
            }

            public String getArea() {
                return area;
            }

            public void setArea(String area) {
                this.area = area;
            }

            public int getBrdId() {
                return brdId;
            }

            public void setBrdId(int brdId) {
                this.brdId = brdId;
            }

            public int getDealPrice() {
                return dealPrice;
            }

            public void setDealPrice(int dealPrice) {
                this.dealPrice = dealPrice;
            }

            public int getReferencePrice() {
                return referencePrice;
            }

            public void setReferencePrice(int referencePrice) {
                this.referencePrice = referencePrice;
            }

            public int getShowCount() {
                return showCount;
            }

            public void setShowCount(int showCount) {
                this.showCount = showCount;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }
        }

        public static class changpingBean {
            private String addr;
            private String nm;
            private String ct;
            private int deal;
            private String dis;
            private String brd;
            private int distance;
            private int follow;
            private int imax;
            private int sellPrice;
            private int poiId;
            private double lat;
            private double lng;
            private boolean sell;
            private int sellmin;
            private int preferential;
            private String area;
            private int brdId;
            private int dealPrice;
            private int referencePrice;
            private int showCount;
            private int id;

            public String getAddr() {
                return addr;
            }

            public void setAddr(String addr) {
                this.addr = addr;
            }

            public String getNm() {
                return nm;
            }

            public void setNm(String nm) {
                this.nm = nm;
            }

            public String getCt() {
                return ct;
            }

            public void setCt(String ct) {
                this.ct = ct;
            }

            public int getDeal() {
                return deal;
            }

            public void setDeal(int deal) {
                this.deal = deal;
            }

            public String getDis() {
                return dis;
            }

            public void setDis(String dis) {
                this.dis = dis;
            }

            public String getBrd() {
                return brd;
            }

            public void setBrd(String brd) {
                this.brd = brd;
            }

            public int getDistance() {
                return distance;
            }

            public void setDistance(int distance) {
                this.distance = distance;
            }

            public int getFollow() {
                return follow;
            }

            public void setFollow(int follow) {
                this.follow = follow;
            }

            public int getImax() {
                return imax;
            }

            public void setImax(int imax) {
                this.imax = imax;
            }

            public int getSellPrice() {
                return sellPrice;
            }

            public void setSellPrice(int sellPrice) {
                this.sellPrice = sellPrice;
            }

            public int getPoiId() {
                return poiId;
            }

            public void setPoiId(int poiId) {
                this.poiId = poiId;
            }

            public double getLat() {
                return lat;
            }

            public void setLat(double lat) {
                this.lat = lat;
            }

            public double getLng() {
                return lng;
            }

            public void setLng(double lng) {
                this.lng = lng;
            }

            public boolean isSell() {
                return sell;
            }

            public void setSell(boolean sell) {
                this.sell = sell;
            }

            public int getSellmin() {
                return sellmin;
            }

            public void setSellmin(int sellmin) {
                this.sellmin = sellmin;
            }

            public int getPreferential() {
                return preferential;
            }

            public void setPreferential(int preferential) {
                this.preferential = preferential;
            }

            public String getArea() {
                return area;
            }

            public void setArea(String area) {
                this.area = area;
            }

            public int getBrdId() {
                return brdId;
            }

            public void setBrdId(int brdId) {
                this.brdId = brdId;
            }

            public int getDealPrice() {
                return dealPrice;
            }

            public void setDealPrice(int dealPrice) {
                this.dealPrice = dealPrice;
            }

            public int getReferencePrice() {
                return referencePrice;
            }

            public void setReferencePrice(int referencePrice) {
                this.referencePrice = referencePrice;
            }

            public int getShowCount() {
                return showCount;
            }

            public void setShowCount(int showCount) {
                this.showCount = showCount;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }
        }

        public static class fangshanBean {
            private String addr;
            private String nm;
            private String ct;
            private int deal;
            private String dis;
            private String brd;
            private int distance;
            private int follow;
            private int imax;
            private int sellPrice;
            private int poiId;
            private double lat;
            private double lng;
            private boolean sell;
            private int sellmin;
            private int preferential;
            private String area;
            private int brdId;
            private int dealPrice;
            private int referencePrice;
            private int showCount;
            private int id;

            public String getAddr() {
                return addr;
            }

            public void setAddr(String addr) {
                this.addr = addr;
            }

            public String getNm() {
                return nm;
            }

            public void setNm(String nm) {
                this.nm = nm;
            }

            public String getCt() {
                return ct;
            }

            public void setCt(String ct) {
                this.ct = ct;
            }

            public int getDeal() {
                return deal;
            }

            public void setDeal(int deal) {
                this.deal = deal;
            }

            public String getDis() {
                return dis;
            }

            public void setDis(String dis) {
                this.dis = dis;
            }

            public String getBrd() {
                return brd;
            }

            public void setBrd(String brd) {
                this.brd = brd;
            }

            public int getDistance() {
                return distance;
            }

            public void setDistance(int distance) {
                this.distance = distance;
            }

            public int getFollow() {
                return follow;
            }

            public void setFollow(int follow) {
                this.follow = follow;
            }

            public int getImax() {
                return imax;
            }

            public void setImax(int imax) {
                this.imax = imax;
            }

            public int getSellPrice() {
                return sellPrice;
            }

            public void setSellPrice(int sellPrice) {
                this.sellPrice = sellPrice;
            }

            public int getPoiId() {
                return poiId;
            }

            public void setPoiId(int poiId) {
                this.poiId = poiId;
            }

            public double getLat() {
                return lat;
            }

            public void setLat(double lat) {
                this.lat = lat;
            }

            public double getLng() {
                return lng;
            }

            public void setLng(double lng) {
                this.lng = lng;
            }

            public boolean isSell() {
                return sell;
            }

            public void setSell(boolean sell) {
                this.sell = sell;
            }

            public int getSellmin() {
                return sellmin;
            }

            public void setSellmin(int sellmin) {
                this.sellmin = sellmin;
            }

            public int getPreferential() {
                return preferential;
            }

            public void setPreferential(int preferential) {
                this.preferential = preferential;
            }

            public String getArea() {
                return area;
            }

            public void setArea(String area) {
                this.area = area;
            }

            public int getBrdId() {
                return brdId;
            }

            public void setBrdId(int brdId) {
                this.brdId = brdId;
            }

            public int getDealPrice() {
                return dealPrice;
            }

            public void setDealPrice(int dealPrice) {
                this.dealPrice = dealPrice;
            }

            public int getReferencePrice() {
                return referencePrice;
            }

            public void setReferencePrice(int referencePrice) {
                this.referencePrice = referencePrice;
            }

            public int getShowCount() {
                return showCount;
            }

            public void setShowCount(int showCount) {
                this.showCount = showCount;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }
        }

        public static class shunyiBean {
            private String addr;
            private String nm;
            private String ct;
            private int deal;
            private String dis;
            private String brd;
            private int distance;
            private int follow;
            private int imax;
            private int sellPrice;
            private int poiId;
            private double lat;
            private double lng;
            private boolean sell;
            private int sellmin;
            private int preferential;
            private String area;
            private int brdId;
            private int dealPrice;
            private int referencePrice;
            private int showCount;
            private int id;

            public String getAddr() {
                return addr;
            }

            public void setAddr(String addr) {
                this.addr = addr;
            }

            public String getNm() {
                return nm;
            }

            public void setNm(String nm) {
                this.nm = nm;
            }

            public String getCt() {
                return ct;
            }

            public void setCt(String ct) {
                this.ct = ct;
            }

            public int getDeal() {
                return deal;
            }

            public void setDeal(int deal) {
                this.deal = deal;
            }

            public String getDis() {
                return dis;
            }

            public void setDis(String dis) {
                this.dis = dis;
            }

            public String getBrd() {
                return brd;
            }

            public void setBrd(String brd) {
                this.brd = brd;
            }

            public int getDistance() {
                return distance;
            }

            public void setDistance(int distance) {
                this.distance = distance;
            }

            public int getFollow() {
                return follow;
            }

            public void setFollow(int follow) {
                this.follow = follow;
            }

            public int getImax() {
                return imax;
            }

            public void setImax(int imax) {
                this.imax = imax;
            }

            public int getSellPrice() {
                return sellPrice;
            }

            public void setSellPrice(int sellPrice) {
                this.sellPrice = sellPrice;
            }

            public int getPoiId() {
                return poiId;
            }

            public void setPoiId(int poiId) {
                this.poiId = poiId;
            }

            public double getLat() {
                return lat;
            }

            public void setLat(double lat) {
                this.lat = lat;
            }

            public double getLng() {
                return lng;
            }

            public void setLng(double lng) {
                this.lng = lng;
            }

            public boolean isSell() {
                return sell;
            }

            public void setSell(boolean sell) {
                this.sell = sell;
            }

            public int getSellmin() {
                return sellmin;
            }

            public void setSellmin(int sellmin) {
                this.sellmin = sellmin;
            }

            public int getPreferential() {
                return preferential;
            }

            public void setPreferential(int preferential) {
                this.preferential = preferential;
            }

            public String getArea() {
                return area;
            }

            public void setArea(String area) {
                this.area = area;
            }

            public int getBrdId() {
                return brdId;
            }

            public void setBrdId(int brdId) {
                this.brdId = brdId;
            }

            public int getDealPrice() {
                return dealPrice;
            }

            public void setDealPrice(int dealPrice) {
                this.dealPrice = dealPrice;
            }

            public int getReferencePrice() {
                return referencePrice;
            }

            public void setReferencePrice(int referencePrice) {
                this.referencePrice = referencePrice;
            }

            public int getShowCount() {
                return showCount;
            }

            public void setShowCount(int showCount) {
                this.showCount = showCount;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }
        }

        public static class mentougouBean {
            private String addr;
            private String nm;
            private String ct;
            private int deal;
            private String dis;
            private String brd;
            private int distance;
            private int follow;
            private int imax;
            private int sellPrice;
            private int poiId;
            private double lat;
            private double lng;
            private boolean sell;
            private int sellmin;
            private int preferential;
            private String area;
            private int brdId;
            private int dealPrice;
            private int referencePrice;
            private int showCount;
            private int id;

            public String getAddr() {
                return addr;
            }

            public void setAddr(String addr) {
                this.addr = addr;
            }

            public String getNm() {
                return nm;
            }

            public void setNm(String nm) {
                this.nm = nm;
            }

            public String getCt() {
                return ct;
            }

            public void setCt(String ct) {
                this.ct = ct;
            }

            public int getDeal() {
                return deal;
            }

            public void setDeal(int deal) {
                this.deal = deal;
            }

            public String getDis() {
                return dis;
            }

            public void setDis(String dis) {
                this.dis = dis;
            }

            public String getBrd() {
                return brd;
            }

            public void setBrd(String brd) {
                this.brd = brd;
            }

            public int getDistance() {
                return distance;
            }

            public void setDistance(int distance) {
                this.distance = distance;
            }

            public int getFollow() {
                return follow;
            }

            public void setFollow(int follow) {
                this.follow = follow;
            }

            public int getImax() {
                return imax;
            }

            public void setImax(int imax) {
                this.imax = imax;
            }

            public int getSellPrice() {
                return sellPrice;
            }

            public void setSellPrice(int sellPrice) {
                this.sellPrice = sellPrice;
            }

            public int getPoiId() {
                return poiId;
            }

            public void setPoiId(int poiId) {
                this.poiId = poiId;
            }

            public double getLat() {
                return lat;
            }

            public void setLat(double lat) {
                this.lat = lat;
            }

            public double getLng() {
                return lng;
            }

            public void setLng(double lng) {
                this.lng = lng;
            }

            public boolean isSell() {
                return sell;
            }

            public void setSell(boolean sell) {
                this.sell = sell;
            }

            public int getSellmin() {
                return sellmin;
            }

            public void setSellmin(int sellmin) {
                this.sellmin = sellmin;
            }

            public int getPreferential() {
                return preferential;
            }

            public void setPreferential(int preferential) {
                this.preferential = preferential;
            }

            public String getArea() {
                return area;
            }

            public void setArea(String area) {
                this.area = area;
            }

            public int getBrdId() {
                return brdId;
            }

            public void setBrdId(int brdId) {
                this.brdId = brdId;
            }

            public int getDealPrice() {
                return dealPrice;
            }

            public void setDealPrice(int dealPrice) {
                this.dealPrice = dealPrice;
            }

            public int getReferencePrice() {
                return referencePrice;
            }

            public void setReferencePrice(int referencePrice) {
                this.referencePrice = referencePrice;
            }

            public int getShowCount() {
                return showCount;
            }

            public void setShowCount(int showCount) {
                this.showCount = showCount;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }
        }

        public static class shijingshanBean {
            private String addr;
            private String nm;
            private String ct;
            private int deal;
            private String dis;
            private String brd;
            private int distance;
            private int follow;
            private int imax;
            private int sellPrice;
            private int poiId;
            private double lat;
            private double lng;
            private boolean sell;
            private int sellmin;
            private int preferential;
            private String area;
            private int brdId;
            private int dealPrice;
            private int referencePrice;
            private int showCount;
            private int id;

            public String getAddr() {
                return addr;
            }

            public void setAddr(String addr) {
                this.addr = addr;
            }

            public String getNm() {
                return nm;
            }

            public void setNm(String nm) {
                this.nm = nm;
            }

            public String getCt() {
                return ct;
            }

            public void setCt(String ct) {
                this.ct = ct;
            }

            public int getDeal() {
                return deal;
            }

            public void setDeal(int deal) {
                this.deal = deal;
            }

            public String getDis() {
                return dis;
            }

            public void setDis(String dis) {
                this.dis = dis;
            }

            public String getBrd() {
                return brd;
            }

            public void setBrd(String brd) {
                this.brd = brd;
            }

            public int getDistance() {
                return distance;
            }

            public void setDistance(int distance) {
                this.distance = distance;
            }

            public int getFollow() {
                return follow;
            }

            public void setFollow(int follow) {
                this.follow = follow;
            }

            public int getImax() {
                return imax;
            }

            public void setImax(int imax) {
                this.imax = imax;
            }

            public int getSellPrice() {
                return sellPrice;
            }

            public void setSellPrice(int sellPrice) {
                this.sellPrice = sellPrice;
            }

            public int getPoiId() {
                return poiId;
            }

            public void setPoiId(int poiId) {
                this.poiId = poiId;
            }

            public double getLat() {
                return lat;
            }

            public void setLat(double lat) {
                this.lat = lat;
            }

            public double getLng() {
                return lng;
            }

            public void setLng(double lng) {
                this.lng = lng;
            }

            public boolean isSell() {
                return sell;
            }

            public void setSell(boolean sell) {
                this.sell = sell;
            }

            public int getSellmin() {
                return sellmin;
            }

            public void setSellmin(int sellmin) {
                this.sellmin = sellmin;
            }

            public int getPreferential() {
                return preferential;
            }

            public void setPreferential(int preferential) {
                this.preferential = preferential;
            }

            public String getArea() {
                return area;
            }

            public void setArea(String area) {
                this.area = area;
            }

            public int getBrdId() {
                return brdId;
            }

            public void setBrdId(int brdId) {
                this.brdId = brdId;
            }

            public int getDealPrice() {
                return dealPrice;
            }

            public void setDealPrice(int dealPrice) {
                this.dealPrice = dealPrice;
            }

            public int getReferencePrice() {
                return referencePrice;
            }

            public void setReferencePrice(int referencePrice) {
                this.referencePrice = referencePrice;
            }

            public int getShowCount() {
                return showCount;
            }

            public void setShowCount(int showCount) {
                this.showCount = showCount;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }
        }

        public static class huairouBean {
            private String addr;
            private String nm;
            private String ct;
            private int deal;
            private String dis;
            private String brd;
            private int distance;
            private int follow;
            private int imax;
            private int sellPrice;
            private int poiId;
            private double lat;
            private double lng;
            private boolean sell;
            private int sellmin;
            private int preferential;
            private String area;
            private int brdId;
            private int dealPrice;
            private int referencePrice;
            private int showCount;
            private int id;

            public String getAddr() {
                return addr;
            }

            public void setAddr(String addr) {
                this.addr = addr;
            }

            public String getNm() {
                return nm;
            }

            public void setNm(String nm) {
                this.nm = nm;
            }

            public String getCt() {
                return ct;
            }

            public void setCt(String ct) {
                this.ct = ct;
            }

            public int getDeal() {
                return deal;
            }

            public void setDeal(int deal) {
                this.deal = deal;
            }

            public String getDis() {
                return dis;
            }

            public void setDis(String dis) {
                this.dis = dis;
            }

            public String getBrd() {
                return brd;
            }

            public void setBrd(String brd) {
                this.brd = brd;
            }

            public int getDistance() {
                return distance;
            }

            public void setDistance(int distance) {
                this.distance = distance;
            }

            public int getFollow() {
                return follow;
            }

            public void setFollow(int follow) {
                this.follow = follow;
            }

            public int getImax() {
                return imax;
            }

            public void setImax(int imax) {
                this.imax = imax;
            }

            public int getSellPrice() {
                return sellPrice;
            }

            public void setSellPrice(int sellPrice) {
                this.sellPrice = sellPrice;
            }

            public int getPoiId() {
                return poiId;
            }

            public void setPoiId(int poiId) {
                this.poiId = poiId;
            }

            public double getLat() {
                return lat;
            }

            public void setLat(double lat) {
                this.lat = lat;
            }

            public double getLng() {
                return lng;
            }

            public void setLng(double lng) {
                this.lng = lng;
            }

            public boolean isSell() {
                return sell;
            }

            public void setSell(boolean sell) {
                this.sell = sell;
            }

            public int getSellmin() {
                return sellmin;
            }

            public void setSellmin(int sellmin) {
                this.sellmin = sellmin;
            }

            public int getPreferential() {
                return preferential;
            }

            public void setPreferential(int preferential) {
                this.preferential = preferential;
            }

            public String getArea() {
                return area;
            }

            public void setArea(String area) {
                this.area = area;
            }

            public int getBrdId() {
                return brdId;
            }

            public void setBrdId(int brdId) {
                this.brdId = brdId;
            }

            public int getDealPrice() {
                return dealPrice;
            }

            public void setDealPrice(int dealPrice) {
                this.dealPrice = dealPrice;
            }

            public int getReferencePrice() {
                return referencePrice;
            }

            public void setReferencePrice(int referencePrice) {
                this.referencePrice = referencePrice;
            }

            public int getShowCount() {
                return showCount;
            }

            public void setShowCount(int showCount) {
                this.showCount = showCount;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }
        }

        public static class pingguBean {
            private String addr;
            private String nm;
            private String ct;
            private int deal;
            private String dis;
            private String brd;
            private int distance;
            private int follow;
            private int imax;
            private int sellPrice;
            private int poiId;
            private double lat;
            private double lng;
            private boolean sell;
            private int sellmin;
            private int preferential;
            private String area;
            private int brdId;
            private int dealPrice;
            private int referencePrice;
            private int showCount;
            private int id;

            public String getAddr() {
                return addr;
            }

            public void setAddr(String addr) {
                this.addr = addr;
            }

            public String getNm() {
                return nm;
            }

            public void setNm(String nm) {
                this.nm = nm;
            }

            public String getCt() {
                return ct;
            }

            public void setCt(String ct) {
                this.ct = ct;
            }

            public int getDeal() {
                return deal;
            }

            public void setDeal(int deal) {
                this.deal = deal;
            }

            public String getDis() {
                return dis;
            }

            public void setDis(String dis) {
                this.dis = dis;
            }

            public String getBrd() {
                return brd;
            }

            public void setBrd(String brd) {
                this.brd = brd;
            }

            public int getDistance() {
                return distance;
            }

            public void setDistance(int distance) {
                this.distance = distance;
            }

            public int getFollow() {
                return follow;
            }

            public void setFollow(int follow) {
                this.follow = follow;
            }

            public int getImax() {
                return imax;
            }

            public void setImax(int imax) {
                this.imax = imax;
            }

            public int getSellPrice() {
                return sellPrice;
            }

            public void setSellPrice(int sellPrice) {
                this.sellPrice = sellPrice;
            }

            public int getPoiId() {
                return poiId;
            }

            public void setPoiId(int poiId) {
                this.poiId = poiId;
            }

            public double getLat() {
                return lat;
            }

            public void setLat(double lat) {
                this.lat = lat;
            }

            public double getLng() {
                return lng;
            }

            public void setLng(double lng) {
                this.lng = lng;
            }

            public boolean isSell() {
                return sell;
            }

            public void setSell(boolean sell) {
                this.sell = sell;
            }

            public int getSellmin() {
                return sellmin;
            }

            public void setSellmin(int sellmin) {
                this.sellmin = sellmin;
            }

            public int getPreferential() {
                return preferential;
            }

            public void setPreferential(int preferential) {
                this.preferential = preferential;
            }

            public String getArea() {
                return area;
            }

            public void setArea(String area) {
                this.area = area;
            }

            public int getBrdId() {
                return brdId;
            }

            public void setBrdId(int brdId) {
                this.brdId = brdId;
            }

            public int getDealPrice() {
                return dealPrice;
            }

            public void setDealPrice(int dealPrice) {
                this.dealPrice = dealPrice;
            }

            public int getReferencePrice() {
                return referencePrice;
            }

            public void setReferencePrice(int referencePrice) {
                this.referencePrice = referencePrice;
            }

            public int getShowCount() {
                return showCount;
            }

            public void setShowCount(int showCount) {
                this.showCount = showCount;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }
        }

        public static class miyunBean {
            private String addr;
            private String nm;
            private String ct;
            private int deal;
            private String dis;
            private String brd;
            private int distance;
            private int follow;
            private int imax;
            private int sellPrice;
            private int poiId;
            private double lat;
            private double lng;
            private boolean sell;
            private int sellmin;
            private int preferential;
            private String area;
            private int brdId;
            private int dealPrice;
            private int referencePrice;
            private int showCount;
            private int id;

            public String getAddr() {
                return addr;
            }

            public void setAddr(String addr) {
                this.addr = addr;
            }

            public String getNm() {
                return nm;
            }

            public void setNm(String nm) {
                this.nm = nm;
            }

            public String getCt() {
                return ct;
            }

            public void setCt(String ct) {
                this.ct = ct;
            }

            public int getDeal() {
                return deal;
            }

            public void setDeal(int deal) {
                this.deal = deal;
            }

            public String getDis() {
                return dis;
            }

            public void setDis(String dis) {
                this.dis = dis;
            }

            public String getBrd() {
                return brd;
            }

            public void setBrd(String brd) {
                this.brd = brd;
            }

            public int getDistance() {
                return distance;
            }

            public void setDistance(int distance) {
                this.distance = distance;
            }

            public int getFollow() {
                return follow;
            }

            public void setFollow(int follow) {
                this.follow = follow;
            }

            public int getImax() {
                return imax;
            }

            public void setImax(int imax) {
                this.imax = imax;
            }

            public int getSellPrice() {
                return sellPrice;
            }

            public void setSellPrice(int sellPrice) {
                this.sellPrice = sellPrice;
            }

            public int getPoiId() {
                return poiId;
            }

            public void setPoiId(int poiId) {
                this.poiId = poiId;
            }

            public double getLat() {
                return lat;
            }

            public void setLat(double lat) {
                this.lat = lat;
            }

            public double getLng() {
                return lng;
            }

            public void setLng(double lng) {
                this.lng = lng;
            }

            public boolean isSell() {
                return sell;
            }

            public void setSell(boolean sell) {
                this.sell = sell;
            }

            public int getSellmin() {
                return sellmin;
            }

            public void setSellmin(int sellmin) {
                this.sellmin = sellmin;
            }

            public int getPreferential() {
                return preferential;
            }

            public void setPreferential(int preferential) {
                this.preferential = preferential;
            }

            public String getArea() {
                return area;
            }

            public void setArea(String area) {
                this.area = area;
            }

            public int getBrdId() {
                return brdId;
            }

            public void setBrdId(int brdId) {
                this.brdId = brdId;
            }

            public int getDealPrice() {
                return dealPrice;
            }

            public void setDealPrice(int dealPrice) {
                this.dealPrice = dealPrice;
            }

            public int getReferencePrice() {
                return referencePrice;
            }

            public void setReferencePrice(int referencePrice) {
                this.referencePrice = referencePrice;
            }

            public int getShowCount() {
                return showCount;
            }

            public void setShowCount(int showCount) {
                this.showCount = showCount;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }
        }

        public static class yanqingBean {
            private String addr;
            private String nm;
            private String ct;
            private int deal;
            private String dis;
            private String brd;
            private int distance;
            private int follow;
            private int imax;
            private int sellPrice;
            private int poiId;
            private double lat;
            private double lng;
            private boolean sell;
            private int sellmin;
            private int preferential;
            private String area;
            private int brdId;
            private int dealPrice;
            private int referencePrice;
            private int showCount;
            private int id;

            public String getAddr() {
                return addr;
            }

            public void setAddr(String addr) {
                this.addr = addr;
            }

            public String getNm() {
                return nm;
            }

            public void setNm(String nm) {
                this.nm = nm;
            }

            public String getCt() {
                return ct;
            }

            public void setCt(String ct) {
                this.ct = ct;
            }

            public int getDeal() {
                return deal;
            }

            public void setDeal(int deal) {
                this.deal = deal;
            }

            public String getDis() {
                return dis;
            }

            public void setDis(String dis) {
                this.dis = dis;
            }

            public String getBrd() {
                return brd;
            }

            public void setBrd(String brd) {
                this.brd = brd;
            }

            public int getDistance() {
                return distance;
            }

            public void setDistance(int distance) {
                this.distance = distance;
            }

            public int getFollow() {
                return follow;
            }

            public void setFollow(int follow) {
                this.follow = follow;
            }

            public int getImax() {
                return imax;
            }

            public void setImax(int imax) {
                this.imax = imax;
            }

            public int getSellPrice() {
                return sellPrice;
            }

            public void setSellPrice(int sellPrice) {
                this.sellPrice = sellPrice;
            }

            public int getPoiId() {
                return poiId;
            }

            public void setPoiId(int poiId) {
                this.poiId = poiId;
            }

            public double getLat() {
                return lat;
            }

            public void setLat(double lat) {
                this.lat = lat;
            }

            public double getLng() {
                return lng;
            }

            public void setLng(double lng) {
                this.lng = lng;
            }

            public boolean isSell() {
                return sell;
            }

            public void setSell(boolean sell) {
                this.sell = sell;
            }

            public int getSellmin() {
                return sellmin;
            }

            public void setSellmin(int sellmin) {
                this.sellmin = sellmin;
            }

            public int getPreferential() {
                return preferential;
            }

            public void setPreferential(int preferential) {
                this.preferential = preferential;
            }

            public String getArea() {
                return area;
            }

            public void setArea(String area) {
                this.area = area;
            }

            public int getBrdId() {
                return brdId;
            }

            public void setBrdId(int brdId) {
                this.brdId = brdId;
            }

            public int getDealPrice() {
                return dealPrice;
            }

            public void setDealPrice(int dealPrice) {
                this.dealPrice = dealPrice;
            }

            public int getReferencePrice() {
                return referencePrice;
            }

            public void setReferencePrice(int referencePrice) {
                this.referencePrice = referencePrice;
            }

            public int getShowCount() {
                return showCount;
            }

            public void setShowCount(int showCount) {
                this.showCount = showCount;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }
        }
    }
}
