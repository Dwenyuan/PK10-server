<?php
/*
 *网页授权获取用户openid
*/
header("Content-type:text/html;charset=utf-8");
echo '<meta name="viewport" content="width=device-width,initial-scale=1">';
$code=$_GET['code'];
$url="https://api.weixin.qq.com/sns/oauth2/access_token?appid=wxffe190dec3271a1c&secret=4192f1eb31b0ebf5c8fbf7fcd80a7913&code=".$code."&grant_type=authorization_code";
$openidarr=json_decode(gettoken($url),ture);

//print_r($openidarr);
$token=$openidarr['access_token'];
$openid=$openidarr['openid'];
//echo $openidarr['openid'];

$infourl="https://api.weixin.qq.com/sns/userinfo?access_token=".$token."&openid=".$openid."&lang=zh_CN";
$userinfoarr=json_decode(gettoken($infourl),ture);
//print_r($userinfoarr);

echo $userinfoarr['nickname']."<br />";
echo $userinfoarr['city']."<br />";
echo $userinfoarr['headimgurl'];
function gettoken($url)
{
	$ch = curl_init();
	curl_setopt($ch, CURLOPT_URL, $url);
	curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
	curl_setopt($ch, CURLOPT_HEADER, 0);
	curl_setopt($ch, CURLOPT_USERAGENT, "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.22 (KHTML, like Gecko) Chrome/25.0.1364.172 Safari/537.22");
	curl_setopt($ch, CURLOPT_ENCODING ,'gzip'); //加入gzip解析
	curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, false); 
	$output = curl_exec($ch);
	curl_close($ch);
	return $output;
}
?>