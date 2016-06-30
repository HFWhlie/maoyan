package com.atguigu.maoyan.Utils;

/**
 * Created by tao on 2016/6/23.
 */
public class URL {

    //欢迎页面的电影图片
    public static final String welUrl = "http://api.meituan.com/dianying/posters.json?city_id=1&poster_type=1&__vhost=api.maoyan.com&utm_campaign=AmovieBmovieCD-1&movieBundleVersion=6801&utm_source=hiapk&utm_medium=android&utm_term=6.8.0&utm_content=860311023305964&ci=1&net=255&dModel=MI%203&uuid=F096369352E4004DD3758BF83FE24AC312445F9B51AD3D8FCE2A0CD57754F6E4&lat=0.0&lng=0.0&__skck=6a375bce8c66a0dc293860dfa83833ef&__skts=1463656383990&__skua=7e01cf8dd30a179800a7a93979b430b2&__skno=09cbe8d3-3cb0-4e54-bc41-8f0b3387cdf2&__skcy=RbOZVh%2BK%2Bf86K3WlGJYg4ls7DIU%3D";
    //热映的接口
    public static final String hoturl = "http://m.maoyan.com/movie/list.json?type=hot&offset=0&limit=1000";
    //热映Viewpager的接口
    public static final String hotPagerurl = "http://advert.mobile.meituan.com/api/v3/adverts?cityid=1&category=11&version=6.8.0&new=0&app=movie&clienttp=android&uuid=FCFAB9D8DD339645D629C8372A29A2C6AD16F9C9E87AF9AC0D656B29DD5AC6DE&devid=866641027400542&uid=&movieid=&partner=1&apptype=1&smId=&utm_campaign=AmovieBmovieCD-1&movieBundleVersion=6801&utm_source=qq&utm_medium=android&utm_term=6.8.0&utm_content=866641027400542&ci=1&net=255&dModel=HM%20NOTE%201LTETD&lat=40.100855&lng=116.378273&__skck=6a375bce8c66a0dc293860dfa83833ef&__skts=1463730432992&__skua=7e01cf8dd30a179800a7a93979b430b2&__skno=01f9c5c0-eb56-4e19-92fb-b86b16ad79da&__skcy=5K8wRR%2FKYAZDTgmAzbhrXi%2FomzU%3D";
    //待映的接口
    public static final String stdyPagerurl = "http://api.meituan.com/mmdb/movie/v2/list/rt/order/coming.json?ci=1&limit=12&token=&__vhost=api.maoyan.com&utm_campaign=AmovieBmovieCD-1&movieBundleVersion=6801&utm_source=xiaomi&utm_medium=android&utm_term=6.8.0&utm_content=868030022327462&net=255&dModel=MI%205&uuid=0894DE03C76F6045D55977B6D4E32B7F3C6AAB02F9CEA042987B380EC5687C43&lat=40.100673&lng=116.378619&__skck=6a375bce8c66a0dc293860dfa83833ef&__skts=1463704714271&__skua=7e01cf8dd30a179800a7a93979b430b2&__skno=1a0b4a9b-44ec-42fc-b110-ead68bcc2824&__skcy=sXcDKbGi20CGXQPPZvhCU3%2FkzdE%3D";
    //海外国家的接口
    public static final String overseastitleurl = "http://api.meituan.com/mmdb/movie/oversea/areas.json?token=&__vhost=api.maoyan.com&utm_campaign=AmovieBmovieCD-1&movieBundleVersion=6801&utm_source=xiaomi&utm_medium=android&utm_term=6.8.0&utm_content=868030022327462&ci=1&net=255&dModel=MI%205&uuid=0894DE03C76F6045D55977B6D4E32B7F3C6AAB02F9CEA042987B380EC5687C43&lat=40.100673&lng=116.378619&__skck=6a375bce8c66a0dc293860dfa83833ef&__skts=1463704930917&__skua=7e01cf8dd30a179800a7a93979b430b2&__skno=e3df01ab-d811-4ff8-868d-9b4a665ee352&__skcy=FZG8h%2Fw31ebpODD3EnjMbBAPTiE%3D";
    //美国的接口
    public static final String meiurl = "http://api.meituan.com/mmdb/movie/oversea/coming.json?area=NA&offset=0&limit=10&token=&__vhost=api.maoyan.com&utm_campaign=AmovieBmovieCD-1&movieBundleVersion=6801&utm_source=hiapk&utm_medium=android&utm_term=6.8.0&utm_content=860311023305964&ci=1&net=255&dModel=MI%203&uuid=F096369352E4004DD3758BF83FE24AC312445F9B51AD3D8FCE2A0CD57754F6E4&lat=40.099337&lng=116.379463&__skck=6a375bce8c66a0dc293860dfa83833ef&__skts=1463979002816&__skua=7e01cf8dd30a179800a7a93979b430b2&__skno=ff7d7258-bf35-49b1-8350-438616853e0b&__skcy=oNlmWR0dK8QqRyoPuJ9SQPBnvk0%3D";
    //韩国的接口
    public static final String hanurl = "http://api.meituan.com/mmdb/movie/oversea/hot.json?area=KR&offset=0&limit=10&token=&__vhost=api.maoyan.com&utm_campaign=AmovieBmovieCD-1&movieBundleVersion=6801&utm_source=hiapk&utm_medium=android&utm_term=6.8.0&utm_content=860311023305964&ci=1&net=255&dModel=MI%203&uuid=F096369352E4004DD3758BF83FE24AC312445F9B51AD3D8FCE2A0CD57754F6E4&lat=40.099337&lng=116.379463&__skck=6a375bce8c66a0dc293860dfa83833ef&__skts=1463979233089&__skua=7e01cf8dd30a179800a7a93979b430b2&__skno=5245fc26-6931-4d8e-8202-4fa32944ea28&__skcy=IQYM%2F257Pcv7b%2FfH8U60gxAsVWg%3Dhttp://api.meituan.com/mmdb/movie/oversea/hot.json?area=KR&offset=0&limit=10&token=&__vhost=api.maoyan.com&utm_campaign=AmovieBmovieCD-1&movieBundleVersion=6801&utm_source=hiapk&utm_medium=android&utm_term=6.8.0&utm_content=860311023305964&ci=1&net=255&dModel=MI%203&uuid=F096369352E4004DD3758BF83FE24AC312445F9B51AD3D8FCE2A0CD57754F6E4&lat=40.099337&lng=116.379463&__skck=6a375bce8c66a0dc293860dfa83833ef&__skts=1463979233089&__skua=7e01cf8dd30a179800a7a93979b430b2&__skno=5245fc26-6931-4d8e-8202-4fa32944ea28&__skcy=IQYM%2F257Pcv7b%2FfH8U60gxAsVWg%3D";
    //日本接口
    public static final String riurl ="http://api.meituan.com/mmdb/movie/oversea/hot.json?area=JP&offset=10&limit=10&token=&__vhost=api.maoyan.com&utm_campaign=AmovieBmovieCD-1&movieBundleVersion=6801&utm_source=hiapk&utm_medium=android&utm_term=6.8.0&utm_content=860311023305964&ci=1&net=255&dModel=MI%203&uuid=F096369352E4004DD3758BF83FE24AC312445F9B51AD3D8FCE2A0CD57754F6E4&lat=40.099337&lng=116.379463&__skck=6a375bce8c66a0dc293860dfa83833ef&__skts=1463979347735&__skua=7e01cf8dd30a179800a7a93979b430b2&__skno=81a99289-f2ad-4e77-b39c-c899764cbf0a&__skcy=ekzQcZxVLz93KYT7pqaKbPIu%2FGo%3D";
    //影院接口
    public static final String cinemaurl = "http://m.maoyan.com/cinemas.json";
    //影院pager的接口
    public static final String cinemaPagerurl = "http://advert.mobile.meituan.com/api/v3/adverts?cityid=1&category=12&version=6.8.0&new=0&app=movie&clienttp=android&uuid=2C2C0ECD557F366849954BEF88D0017AE8F745F113619A0301F4E4E123A4CD7E&devid=000000000000000&uid=&movieid=&partner=1&apptype=1&smId=&utm_campaign=AmovieBpushC110189035496448D-1&movieBundleVersion=6801&utm_source=hiapk&utm_medium=android&utm_term=6.8.0&utm_content=000000000000000&ci=1&net=255&dModel=Google%20Nexus%204%20-%204.3%20-%20API%2018%20-%20768x1280_1&lat=0.0&lng=0.0&__skck=6a375bce8c66a0dc293860dfa83833ef&__skts=1466950481658&__skua=7e01cf8dd30a179800a7a93979b430b2&__skno=376da951-e975-440d-82b9-f4ac14788679&__skcy=a51B0teaxlLzzW5QEnyfCrcq2S0%3D";
    //发现ViewPager的接口
    public static final String findPagerurl = "http://advert.mobile.meituan.com/api/v3/adverts?cityid=1&category=14&version=6.8.0&new=0&app=movie&clienttp=android&uuid=22C117E01E15F95B04242F2BFCC4575F5F5EA8EDB0193ED973FED7FA7B2829BD&devid=353918059801163&uid=&movieid=&partner=1&apptype=1&smId=&utm_campaign=AmovieBmovieCD-1&movieBundleVersion=6801&utm_source=goapk&utm_medium=android&utm_term=6.8.0&utm_content=353918059801163&ci=1&net=255&dModel=Nexus%204&lat=40.100654&lng=116.37805&__skck=6a375bce8c66a0dc293860dfa83833ef&__skts=1463655698510&__skua=7e01cf8dd30a179800a7a93979b430b2&__skno=d4f1e217-fd38-4cda-8d82-ef52b331a71a&__skcy=PL%2BjGyr5ANh3wbigOteOnFr7PLU%3D";
    //发现接口
    public static final String findurl = "http://api.meituan.com/sns/v2/feed.json?offset=0&limit=10&timestamp=0&__vhost=api.maoyan.com&utm_campaign=AmovieBmovieC110189035496448D-1&movieBundleVersion=6801&utm_source=baidumobile1&utm_medium=android&utm_term=6.8.0&utm_content=863777020121611&ci=1&net=255";
    //热映H5页面的链接
    public static final String Hotfive = "http://m.maoyan.com/movie/246188?_v_=yes";
    //影院H5页面的链接
    public static final String Stdyfive = "http://m.maoyan.com/showtime/wrap.json？cinemaid=11533&movieid=request";
    //话题H5页面的链接
    public static final String Htfive = "http://m.maoyan.com/groups?_v_=yes&f=android&userid=-1&pushToken=7e6bd5fe73912116ed3ca24d473265cc37ad738879f590efaf0a436f905b945b103b4d6d4a8cb7a6cd70f822f26ffff9&cityId=1";
    //票房H5页面的链接
    public static final String pffive = "http://m.maoyan.com/newGuide/maoyanpiaofang?f=nohdft";
    //影库最上面的图片的接口
    public static final String movurl = "http://api.maoyan.com/mmdb/daily/recommend/latest/list.json?utm_campaign=AmovieBmovieCD-1&movieBundleVersion=6801&utm_source=xiaomi&utm_medium=android&utm_term=6.8.0&utm_content";
    //热映口碑的接口
    public static final String praiseurl = "http://api.meituan.com/mmdb/movieboard/fixedboard/7.json?offset=0&limit=10&__vhost=api.maoyan.com&utm_campaign=AmovieBmovieC110189035496448D-1&movieBundleVersion=6801&utm_source=hiapk&utm_medium=android&utm_term=6.8.0&utm_content=000000000000000&ci=1&net=255&dModel=Custom%20Phone%20-%204.3%20-%20API%2018%20-%20768x1280&uuid=2C2C0ECD557F366849954BEF88D0017AC98AD8183EC9108E7D92853C8D3EF972&lat=0.0&lng=0.0&__skck=6a375bce8c66a0dc293860dfa83833ef&__skts=1463727372645&__skua=7e01cf8dd30a179800a7a93979b430b2&__skno=26a19547-c4ad-438f-96af-0feadadba2b0&__skcy=S9pqtpXxrUm%2BgC2THRjoEuUzJoY%3D";

}
