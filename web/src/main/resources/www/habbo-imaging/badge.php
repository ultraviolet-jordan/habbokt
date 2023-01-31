<?php
/*===================================================+
|| # HoloCMS - Website and Content Management System
|+===================================================+
|| # Copyright © 2008 Meth0d. All rights reserved.
|| # http://www.meth0d.org
|+===================================================+
|| # HoloCMS is provided "as is" and comes without
|| # warrenty of any kind. HoloCMS is free software!
|+===================================================*/

/** HOLO GROUP BADGE IMAGER
 * @author    Jaym/Kreechin
 * @desc         Dynamicly generate group badge images
 * @usage        <img src='./habbo-imager/badge.php?badge='>
 */

// You may not use, edit, or redistribute this file or any part(s) of it in any
// way, shape, method or format outside HoloCMS without explicit prior
// permission to do so from jaym/kreechin. This file may only be used for
// reference unless otherwise stated by the author.
error_reporting(0);
header("Content-type: image/gif");
$im = imagecreatefromgif("badges/base/base.gif");
$badgedata = $_GET['badge'];

if (empty($badgedata))
{
    exit;
}

$letters = array(
    "b",
    "X"
);
$badgedata = str_replace($letters, "", $badgedata);
$layer = explode("s", $badgedata);
$sourcefile_id = imageCreateFromgif("badges/base/base.gif");

$str = "$layer[0]";
$arr = str_split($str, 2);
if ("$layer[0]" == "")
{
    $lay = "badges/templates/none.gif";
    $lay = imagecreatefromgif($lay);
    imagecopy($im, $lay, 0, 0, 0, 0, 0, 0);
}
else
{
    $colcode = $arr[1];
    if ("$colcode" == "01")
    {
        $col = '0xff0xd60x01';
    }
    elseif ("$colcode" == "02")
    {
        $col = '0xee0x760x00';
    }
    elseif ("$colcode" == "03")
    {
        $col = '0x840xde0x00';
    }
    elseif ("$colcode" == "04")
    {
        $col = '0x580x9a0x00';
    }
    elseif ("$colcode" == "05")
    {
        $col = '0x500xc10xfb';
    }
    elseif ("$colcode" == "06")
    {
        $col = '0x000x6f0xcf';
    }
    elseif ("$colcode" == "07")
    {
        $col = '0xff0x980xe3';
    }
    elseif ("$colcode" == "08")
    {
        $col = '0xf30x340xbf';
    }
    elseif ("$colcode" == "09")
    {
        $col = '0xff0x2d0x2d';
    }
    elseif ("$colcode" == "10")
    {
        $col = '0xaf0x0a0x0a';
    }
    elseif ("$colcode" == "11")
    {
        $col = '0xff0xff0xff';
    }
    elseif ("$colcode" == "12")
    {
        $col = '0xc00xc00xc0';
    }
    elseif ("$colcode" == "13")
    {
        $col = '0x370x370x37';
    }
    elseif ("$colcode" == "14")
    {
        $col = '0xfb0xe70xac';
    }
    elseif ("$colcode" == "15")
    {
        $col = '0x970x760x41';
    }
    elseif ("$colcode" == "16")
    {
        $col = '0xc20xea0xff';
    }
    elseif ("$colcode" == "17")
    {
        $col = '0xff0xf10x65';
    }
    elseif ("$colcode" == "18")
    {
        $col = '0xaa0xff0x7d';
    }

    $colour = str_split($col, 4);
    $hex1 = $colour[0];
    $hex2 = $colour[1];
    $hex3 = $colour[2];

    function image_colorize(&$img, $rgb)
    {
        imageTrueColorToPalette($img, true, 256);
        $numColors = imageColorsTotal($img);
        for ($x = 0;$x < $numColors;$x++)
        {
            list($r, $g, $b) = array_values(imageColorsForIndex($img, $x));
            $grayscale = ($r + $g + $b) / 3 / 0xff;
            imageColorSet($img, $x, $grayscale * $rgb[0], $grayscale * $rgb[1], $grayscale * $rgb[2]);
        }
    }
    $insertfile_id = imageCreateFromgif("badges/base/$arr[0].gif");
    $sourcefile_width = imageSX($sourcefile_id);
    $insertfile_width = imageSX($insertfile_id);
    $sourcefile_height = imageSY($sourcefile_id);
    $insertfile_height = imageSY($insertfile_id);
    $p = ($sourcefile_width / 2) - ($insertfile_width / 2);
    $pp = ($sourcefile_height / 2) - ($insertfile_height / 2);
    $image = getimagesize("badges/base/$arr[0].gif");
    $h = $image[0];
    $w = $image[1];
    $color = array(
        $hex1,
        $hex2,
        $hex3
    );
    $lay = "badges/base/$arr[0].gif";
    $img = imageCreateFromgif($lay);
    image_colorize($img, $color);
    if (file_exists("badges/base/$arr[0]_$arr[0].gif"))
    {
        $olay = imagecreatefromgif("badges/base/$arr[0]_$arr[0].gif");
        imagecopymerge($img, $olay, 0, 0, 0, 0, $h, $w, 100);
        imagecopy($im, $img, $p, $pp, 0, 0, $h, $w);
    }
    else
    {
        imagecopy($im, $img, $p, $pp, 0, 0, $h, $w);
    }
}

$str1 = "$layer[1]";
$arr1 = str_split($str1, 2);
if ("$layer[1]" == "")
{
    $lay1 = "badges/templates/none.gif";
    $lay1 = imagecreatefromgif($lay1);
    imagecopy($im, $lay1, 0, 0, 0, 0, 0, 0);
}
else
{

    $image = getimagesize("badges/templates/$arr1[0].gif");
    $h = $image[0];
    $w = $image[1];
    $pos = $arr1[2];

    if ("$pos" == "0")
    {
        $p = "0";
        $pp = "0";
    }
    elseif ("$pos" == "1")
    {
        $insertfile_id = imageCreateFromgif("badges/templates/$arr1[0].gif");
        $sourcefile_width = imageSX($sourcefile_id);
        $insertfile_width = imageSX($insertfile_id);
        $p = (($sourcefile_width - $insertfile_width) / 2);
        $pp = 0;
    }
    elseif ("$pos" == "2")
    {
        $insertfile_id = imageCreateFromgif("badges/templates/$arr1[0].gif");
        $sourcefile_width = imageSX($sourcefile_id);
        $insertfile_width = imageSX($insertfile_id);
        $p = $sourcefile_width - $insertfile_width;
        $pp = 0;
    }
    elseif ("$pos" == "3")
    {
        $insertfile_id = imageCreateFromgif("badges/templates/$arr1[0].gif");
        $sourcefile_height = imageSY($sourcefile_id);
        $insertfile_height = imageSY($insertfile_id);
        $p = 0;
        $pp = ($sourcefile_height / 2) - ($insertfile_height / 2);
    }
    elseif ("$pos" == "4")
    {
        $insertfile_id = imageCreateFromgif("badges/templates/$arr1[0].gif");
        $sourcefile_width = imageSX($sourcefile_id);
        $insertfile_width = imageSX($insertfile_id);
        $sourcefile_height = imageSY($sourcefile_id);
        $insertfile_height = imageSY($insertfile_id);
        $p = ($sourcefile_width / 2) - ($insertfile_width / 2);
        $pp = ($sourcefile_height / 2) - ($insertfile_height / 2);
    }
    elseif ("$pos" == "5")
    {
        $insertfile_id = imageCreateFromgif("badges/templates/$arr1[0].gif");
        $sourcefile_width = imageSX($sourcefile_id);
        $insertfile_width = imageSX($insertfile_id);
        $sourcefile_height = imageSY($sourcefile_id);
        $insertfile_height = imageSY($insertfile_id);
        $p = $sourcefile_width - $insertfile_width;
        $pp = ($sourcefile_height / 2) - ($insertfile_height / 2);
    }
    elseif ("$pos" == "6")
    {
        $insertfile_id = imageCreateFromgif("badges/templates/$arr1[0].gif");
        $sourcefile_height = imageSY($sourcefile_id);
        $insertfile_height = imageSY($insertfile_id);
        $p = 0;
        $pp = $sourcefile_height - $insertfile_height;
    }
    elseif ("$pos" == "7")
    {
        $insertfile_id = imageCreateFromgif("badges/templates/$arr1[0].gif");
        $sourcefile_width = imageSX($sourcefile_id);
        $insertfile_width = imageSX($insertfile_id);
        $sourcefile_height = imageSY($sourcefile_id);
        $insertfile_height = imageSY($insertfile_id);
        $p = (($sourcefile_width - $insertfile_width) / 2);
        $pp = $sourcefile_height - $insertfile_height;
    }
    elseif ("$pos" == "8")
    {
        $insertfile_id = imageCreateFromgif("badges/templates/$arr1[0].gif");
        $sourcefile_width = imageSX($sourcefile_id);
        $insertfile_width = imageSX($insertfile_id);
        $sourcefile_height = imageSY($sourcefile_id);
        $insertfile_height = imageSY($insertfile_id);
        $p = $sourcefile_width - $insertfile_width;
        $pp = $sourcefile_height - $insertfile_height;
    }
    $colcode = $arr1[1];
    if ("$colcode" == "01")
    {
        $col = '0xff0xd60x01';
    }
    elseif ("$colcode" == "02")
    {
        $col = '0xee0x760x00';
    }
    elseif ("$colcode" == "03")
    {
        $col = '0x840xde0x00';
    }
    elseif ("$colcode" == "04")
    {
        $col = '0x580x9a0x00';
    }
    elseif ("$colcode" == "05")
    {
        $col = '0x500xc10xfb';
    }
    elseif ("$colcode" == "06")
    {
        $col = '0x000x6f0xcf';
    }
    elseif ("$colcode" == "07")
    {
        $col = '0xff0x980xe3';
    }
    elseif ("$colcode" == "08")
    {
        $col = '0xf30x340xbf';
    }
    elseif ("$colcode" == "09")
    {
        $col = '0xff0x2d0x2d';
    }
    elseif ("$colcode" == "10")
    {
        $col = '0xaf0x0a0x0a';
    }
    elseif ("$colcode" == "11")
    {
        $col = '0xff0xff0xff';
    }
    elseif ("$colcode" == "12")
    {
        $col = '0xc00xc00xc0';
    }
    elseif ("$colcode" == "13")
    {
        $col = '0x370x370x37';
    }
    elseif ("$colcode" == "14")
    {
        $col = '0xfb0xe70xac';
    }
    elseif ("$colcode" == "15")
    {
        $col = '0x970x760x41';
    }
    elseif ("$colcode" == "16")
    {
        $col = '0xc20xea0xff';
    }
    elseif ("$colcode" == "17")
    {
        $col = '0xff0xf10x65';
    }
    elseif ("$colcode" == "18")
    {
        $col = '0xaa0xff0x7d';
    }

    $colour = str_split($col, 4);
    $hex1 = $colour[0];
    $hex2 = $colour[1];
    $hex3 = $colour[2];

    function image_colorize1(&$img, $rgb)
    {
        imageTrueColorToPalette($img, true, 256);
        $numColors = imageColorsTotal($img);
        for ($x = 0;$x < $numColors;$x++)
        {
            list($r, $g, $b) = array_values(imageColorsForIndex($img, $x));
            $grayscale = ($r + $g + $b) / 3 / 0xff;
            imageColorSet($img, $x, $grayscale * $rgb[0], $grayscale * $rgb[1], $grayscale * $rgb[2]);
        }
    }

    $color = array(
        $hex1,
        $hex2,
        $hex3
    );
    $lay1 = "badges/templates/$arr1[0].gif";
    $img = imageCreateFromgif($lay1);
    image_colorize1($img, $color);
    if (file_exists("badges/templates/$arr1[0]_$arr1[0].gif"))
    {
        $olay = imagecreatefromgif("badges/templates/$arr1[0]_$arr1[0].gif");
        imagecopymerge($img, $olay, 0, 0, 0, 0, $h, $w, 100);
        imagecopy($im, $img, $p, $pp, 0, 0, $h, $w);
    }
    else
    {
        imagecopy($im, $img, $p, $pp, 0, 0, $h, $w);
    }
}

$str2 = "$layer[2]";
$arr2 = str_split($str2, 2);
if ("$layer[2]" == "")
{
    $lay2 = "badges/templates/none.gif";
    $lay2 = imagecreatefromgif($lay2);
    imagecopy($im, $lay2, 0, 0, 0, 0, 0, 0);
}
else
{
    $image = getimagesize("badges/templates/$arr2[0].gif");
    $h = $image[0];
    $w = $image[1];
    $pos = $arr2[2];
    if ("$pos" == "0")
    {
        $p = "0";
        $pp = "0";
    }
    elseif ("$pos" == "1")
    {
        $insertfile_id = imageCreateFromgif("badges/templates/$arr2[0].gif");
        $sourcefile_width = imageSX($sourcefile_id);
        $insertfile_width = imageSX($insertfile_id);
        $p = (($sourcefile_width - $insertfile_width) / 2);
        $pp = 0;
    }
    elseif ("$pos" == "2")
    {
        $insertfile_id = imageCreateFromgif("badges/templates/$arr2[0].gif");
        $sourcefile_width = imageSX($sourcefile_id);
        $insertfile_width = imageSX($insertfile_id);
        $p = $sourcefile_width - $insertfile_width;
        $pp = 0;
    }
    elseif ("$pos" == "3")
    {
        $insertfile_id = imageCreateFromgif("badges/templates/$arr2[0].gif");
        $sourcefile_height = imageSY($sourcefile_id);
        $insertfile_height = imageSY($insertfile_id);
        $p = 0;
        $pp = ($sourcefile_height / 2) - ($insertfile_height / 2);
    }
    elseif ("$pos" == "4")
    {
        $insertfile_id = imageCreateFromgif("badges/templates/$arr2[0].gif");
        $sourcefile_width = imageSX($sourcefile_id);
        $insertfile_width = imageSX($insertfile_id);
        $sourcefile_height = imageSY($sourcefile_id);
        $insertfile_height = imageSY($insertfile_id);
        $p = ($sourcefile_width / 2) - ($insertfile_width / 2);
        $pp = ($sourcefile_height / 2) - ($insertfile_height / 2);
    }
    elseif ("$pos" == "5")
    {
        $insertfile_id = imageCreateFromgif("badges/templates/$arr2[0].gif");
        $sourcefile_width = imageSX($sourcefile_id);
        $insertfile_width = imageSX($insertfile_id);
        $sourcefile_height = imageSY($sourcefile_id);
        $insertfile_height = imageSY($insertfile_id);
        $p = $sourcefile_width - $insertfile_width;
        $pp = ($sourcefile_height / 2) - ($insertfile_height / 2);
    }
    elseif ("$pos" == "6")
    {
        $insertfile_id = imageCreateFromgif("badges/templates/$arr2[0].gif");
        $sourcefile_height = imageSY($sourcefile_id);
        $insertfile_height = imageSY($insertfile_id);
        $p = 0;
        $pp = $sourcefile_height - $insertfile_height;
    }
    elseif ("$pos" == "7")
    {
        $insertfile_id = imageCreateFromgif("badges/templates/$arr2[0].gif");
        $sourcefile_width = imageSX($sourcefile_id);
        $insertfile_width = imageSX($insertfile_id);
        $sourcefile_height = imageSY($sourcefile_id);
        $insertfile_height = imageSY($insertfile_id);
        $p = (($sourcefile_width - $insertfile_width) / 2);
        $pp = $sourcefile_height - $insertfile_height;
    }
    elseif ("$pos" == "8")
    {
        $insertfile_id = imageCreateFromgif("badges/templates/$arr2[0].gif");
        $sourcefile_width = imageSX($sourcefile_id);
        $insertfile_width = imageSX($insertfile_id);
        $sourcefile_height = imageSY($sourcefile_id);
        $insertfile_height = imageSY($insertfile_id);
        $p = $sourcefile_width - $insertfile_width;
        $pp = $sourcefile_height - $insertfile_height;
    }
    $colcode = $arr2[1];
    if ("$colcode" == "01")
    {
        $col = '0xff0xd60x01';
    }
    elseif ("$colcode" == "02")
    {
        $col = '0xee0x760x00';
    }
    elseif ("$colcode" == "03")
    {
        $col = '0x840xde0x00';
    }
    elseif ("$colcode" == "04")
    {
        $col = '0x580x9a0x00';
    }
    elseif ("$colcode" == "05")
    {
        $col = '0x500xc10xfb';
    }
    elseif ("$colcode" == "06")
    {
        $col = '0x000x6f0xcf';
    }
    elseif ("$colcode" == "07")
    {
        $col = '0xff0x980xe3';
    }
    elseif ("$colcode" == "08")
    {
        $col = '0xf30x340xbf';
    }
    elseif ("$colcode" == "09")
    {
        $col = '0xff0x2d0x2d';
    }
    elseif ("$colcode" == "10")
    {
        $col = '0xaf0x0a0x0a';
    }
    elseif ("$colcode" == "11")
    {
        $col = '0xff0xff0xff';
    }
    elseif ("$colcode" == "12")
    {
        $col = '0xc00xc00xc0';
    }
    elseif ("$colcode" == "13")
    {
        $col = '0x370x370x37';
    }
    elseif ("$colcode" == "14")
    {
        $col = '0xfb0xe70xac';
    }
    elseif ("$colcode" == "15")
    {
        $col = '0x970x760x41';
    }
    elseif ("$colcode" == "16")
    {
        $col = '0xc20xea0xff';
    }
    elseif ("$colcode" == "17")
    {
        $col = '0xff0xf10x65';
    }
    elseif ("$colcode" == "18")
    {
        $col = '0xaa0xff0x7d';
    }

    $colour = str_split($col, 4);
    $hex1 = $colour[0];
    $hex2 = $colour[1];
    $hex3 = $colour[2];

    function image_colorize2(&$img, $rgb)
    {
        imageTrueColorToPalette($img, true, 256);
        $numColors = imageColorsTotal($img);
        for ($x = 0;$x < $numColors;$x++)
        {
            list($r, $g, $b) = array_values(imageColorsForIndex($img, $x));
            $grayscale = ($r + $g + $b) / 3 / 0xff;
            imageColorSet($img, $x, $grayscale * $rgb[0], $grayscale * $rgb[1], $grayscale * $rgb[2]);
        }
    }
    $color = array(
        $hex1,
        $hex2,
        $hex3
    );
    $lay2 = "badges/templates/$arr2[0].gif";
    $img = imageCreateFromgif($lay2);
    image_colorize2($img, $color);
    if (file_exists("badges/templates/$arr2[0]_$arr2[0].gif"))
    {
        $olay = imagecreatefromgif("badges/templates/$arr2[0]_$arr2[0].gif");
        imagecopymerge($img, $olay, 0, 0, 0, 0, $h, $w, 100);
        imagecopy($im, $img, $p, $pp, 0, 0, $h, $w);
    }
    else
    {
        imagecopy($im, $img, $p, $pp, 0, 0, $h, $w);
    }
}

$str3 = "$layer[3]";
$arr3 = str_split($str3, 2);
if ("$layer[3]" == "")
{
    $lay3 = "badges/templates/none.gif";
    $lay3 = imagecreatefromgif($lay3);
    imagecopy($im, $lay3, 0, 0, 0, 0, 0, 0);
}
else
{
    $image = getimagesize("badges/templates/$arr3[0].gif");
    $h = $image[0];
    $w = $image[1];
    $pos = $arr3[2];
    if ("$pos" == "0")
    {
        $p = "0";
        $pp = "0";
    }
    elseif ("$pos" == "1")
    {
        $insertfile_id = imageCreateFromgif("badges/templates/$arr3[0].gif");
        $sourcefile_width = imageSX($sourcefile_id);
        $insertfile_width = imageSX($insertfile_id);
        $p = (($sourcefile_width - $insertfile_width) / 2);
        $pp = 0;
    }
    elseif ("$pos" == "2")
    {
        $insertfile_id = imageCreateFromgif("badges/templates/$arr3[0].gif");
        $sourcefile_width = imageSX($sourcefile_id);
        $insertfile_width = imageSX($insertfile_id);
        $p = $sourcefile_width - $insertfile_width;
        $pp = 0;
    }
    elseif ("$pos" == "3")
    {
        $insertfile_id = imageCreateFromgif("badges/templates/$arr3[0].gif");
        $sourcefile_height = imageSY($sourcefile_id);
        $insertfile_height = imageSY($insertfile_id);
        $p = 0;
        $pp = ($sourcefile_height / 2) - ($insertfile_height / 2);
    }
    elseif ("$pos" == "4")
    {
        $insertfile_id = imageCreateFromgif("badges/templates/$arr3[0].gif");
        $sourcefile_width = imageSX($sourcefile_id);
        $insertfile_width = imageSX($insertfile_id);
        $sourcefile_height = imageSY($sourcefile_id);
        $insertfile_height = imageSY($insertfile_id);
        $p = ($sourcefile_width / 2) - ($insertfile_width / 2);
        $pp = ($sourcefile_height / 2) - ($insertfile_height / 2);
    }
    elseif ("$pos" == "5")
    {
        $insertfile_id = imageCreateFromgif("badges/templates/$arr3[0].gif");
        $sourcefile_width = imageSX($sourcefile_id);
        $insertfile_width = imageSX($insertfile_id);
        $sourcefile_height = imageSY($sourcefile_id);
        $insertfile_height = imageSY($insertfile_id);
        $p = $sourcefile_width - $insertfile_width;
        $pp = ($sourcefile_height / 2) - ($insertfile_height / 2);
    }
    elseif ("$pos" == "6")
    {
        $insertfile_id = imageCreateFromgif("badges/templates/$arr3[0].gif");
        $sourcefile_height = imageSY($sourcefile_id);
        $insertfile_height = imageSY($insertfile_id);
        $p = 0;
        $pp = $sourcefile_height - $insertfile_height;
    }
    elseif ("$pos" == "7")
    {
        $insertfile_id = imageCreateFromgif("badges/templates/$arr3[0].gif");
        $sourcefile_width = imageSX($sourcefile_id);
        $insertfile_width = imageSX($insertfile_id);
        $sourcefile_height = imageSY($sourcefile_id);
        $insertfile_height = imageSY($insertfile_id);
        $p = (($sourcefile_width - $insertfile_width) / 2);
        $pp = $sourcefile_height - $insertfile_height;
    }
    elseif ("$pos" == "8")
    {
        $insertfile_id = imageCreateFromgif("badges/templates/$arr3[0].gif");
        $sourcefile_width = imageSX($sourcefile_id);
        $insertfile_width = imageSX($insertfile_id);
        $sourcefile_height = imageSY($sourcefile_id);
        $insertfile_height = imageSY($insertfile_id);
        $p = $sourcefile_width - $insertfile_width;
        $pp = $sourcefile_height - $insertfile_height;
    }
    $colcode = $arr3[1];
    if ("$colcode" == "01")
    {
        $col = '0xff0xd60x01';
    }
    elseif ("$colcode" == "02")
    {
        $col = '0xee0x760x00';
    }
    elseif ("$colcode" == "03")
    {
        $col = '0x840xde0x00';
    }
    elseif ("$colcode" == "04")
    {
        $col = '0x580x9a0x00';
    }
    elseif ("$colcode" == "05")
    {
        $col = '0x500xc10xfb';
    }
    elseif ("$colcode" == "06")
    {
        $col = '0x000x6f0xcf';
    }
    elseif ("$colcode" == "07")
    {
        $col = '0xff0x980xe3';
    }
    elseif ("$colcode" == "08")
    {
        $col = '0xf30x340xbf';
    }
    elseif ("$colcode" == "09")
    {
        $col = '0xff0x2d0x2d';
    }
    elseif ("$colcode" == "10")
    {
        $col = '0xaf0x0a0x0a';
    }
    elseif ("$colcode" == "11")
    {
        $col = '0xff0xff0xff';
    }
    elseif ("$colcode" == "12")
    {
        $col = '0xc00xc00xc0';
    }
    elseif ("$colcode" == "13")
    {
        $col = '0x370x370x37';
    }
    elseif ("$colcode" == "14")
    {
        $col = '0xfb0xe70xac';
    }
    elseif ("$colcode" == "15")
    {
        $col = '0x970x760x41';
    }
    elseif ("$colcode" == "16")
    {
        $col = '0xc20xea0xff';
    }
    elseif ("$colcode" == "17")
    {
        $col = '0xff0xf10x65';
    }
    elseif ("$colcode" == "18")
    {
        $col = '0xaa0xff0x7d';
    }

    $colour = str_split($col, 4);
    $hex1 = $colour[0];
    $hex2 = $colour[1];
    $hex3 = $colour[2];

    function image_colorize3(&$img, $rgb)
    {
        imageTrueColorToPalette($img, true, 256);
        $numColors = imageColorsTotal($img);
        for ($x = 0;$x < $numColors;$x++)
        {
            list($r, $g, $b) = array_values(imageColorsForIndex($img, $x));
            $grayscale = ($r + $g + $b) / 3 / 0xff;
            imageColorSet($img, $x, $grayscale * $rgb[0], $grayscale * $rgb[1], $grayscale * $rgb[2]);
        }
    }
    $color = array(
        $hex1,
        $hex2,
        $hex3
    );
    $lay3 = "badges/templates/$arr3[0].gif";
    $img = imageCreateFromgif($lay3);
    image_colorize3($img, $color);
    if (file_exists("badges/templates/$arr3[0]_$arr3[0].gif"))
    {
        $olay = imagecreatefromgif("badges/templates/$arr3[0]_$arr3[0].gif");
        imagecopymerge($img, $olay, 0, 0, 0, 0, $h, $w, 100);
        imagecopy($im, $img, $p, $pp, 0, 0, $h, $w);
    }
    else
    {
        imagecopy($im, $img, $p, $pp, 0, 0, $h, $w);
    }
}

$str4 = "$layer[4]";
$arr4 = str_split($str4, 2);
if ("$layer[4]" == "")
{
    $lay4 = "badges/templates/none.gif";
    $lay4 = imagecreatefromgif($lay4);
    imagecopy($im, $lay4, 0, 0, 0, 0, 0, 0);
}
else
{
    $image = getimagesize("badges/templates/$arr4[0].gif");
    $h = $image[0];
    $w = $image[1];
    $pos = $arr4[2];
    if ("$pos" == "0")
    {
        $p = "0";
        $pp = "0";
    }
    elseif ("$pos" == "1")
    {
        $insertfile_id = imageCreateFromgif("badges/templates/$arr4[0].gif");
        $sourcefile_width = imageSX($sourcefile_id);
        $insertfile_width = imageSX($insertfile_id);
        $p = (($sourcefile_width - $insertfile_width) / 2);
        $pp = 0;
    }
    elseif ("$pos" == "2")
    {
        $insertfile_id = imageCreateFromgif("badges/templates/$arr4[0].gif");
        $sourcefile_width = imageSX($sourcefile_id);
        $insertfile_width = imageSX($insertfile_id);
        $p = $sourcefile_width - $insertfile_width;
        $pp = 0;
    }
    elseif ("$pos" == "3")
    {
        $insertfile_id = imageCreateFromgif("badges/templates/$arr4[0].gif");
        $sourcefile_height = imageSY($sourcefile_id);
        $insertfile_height = imageSY($insertfile_id);
        $p = 0;
        $pp = ($sourcefile_height / 2) - ($insertfile_height / 2);
    }
    elseif ("$pos" == "4")
    {
        $insertfile_id = imageCreateFromgif("badges/templates/$arr4[0].gif");
        $sourcefile_width = imageSX($sourcefile_id);
        $insertfile_width = imageSX($insertfile_id);
        $sourcefile_height = imageSY($sourcefile_id);
        $insertfile_height = imageSY($insertfile_id);
        $p = ($sourcefile_width / 2) - ($insertfile_width / 2);
        $pp = ($sourcefile_height / 2) - ($insertfile_height / 2);
    }
    elseif ("$pos" == "5")
    {
        $insertfile_id = imageCreateFromgif("badges/templates/$arr4[0].gif");
        $sourcefile_width = imageSX($sourcefile_id);
        $insertfile_width = imageSX($insertfile_id);
        $sourcefile_height = imageSY($sourcefile_id);
        $insertfile_height = imageSY($insertfile_id);
        $p = $sourcefile_width - $insertfile_width;
        $pp = ($sourcefile_height / 2) - ($insertfile_height / 2);
    }
    elseif ("$pos" == "6")
    {
        $insertfile_id = imageCreateFromgif("badges/templates/$arr4[0].gif");
        $sourcefile_height = imageSY($sourcefile_id);
        $insertfile_height = imageSY($insertfile_id);
        $p = 0;
        $pp = $sourcefile_height - $insertfile_height;
    }
    elseif ("$pos" == "7")
    {
        $insertfile_id = imageCreateFromgif("badges/templates/$arr4[0].gif");
        $sourcefile_width = imageSX($sourcefile_id);
        $insertfile_width = imageSX($insertfile_id);
        $sourcefile_height = imageSY($sourcefile_id);
        $insertfile_height = imageSY($insertfile_id);
        $p = (($sourcefile_width - $insertfile_width) / 2);
        $pp = $sourcefile_height - $insertfile_height;
    }
    elseif ("$pos" == "8")
    {
        $insertfile_id = imageCreateFromgif("badges/templates/$arr4[0].gif");
        $sourcefile_width = imageSX($sourcefile_id);
        $insertfile_width = imageSX($insertfile_id);
        $sourcefile_height = imageSY($sourcefile_id);
        $insertfile_height = imageSY($insertfile_id);
        $p = $sourcefile_width - $insertfile_width;
        $pp = $sourcefile_height - $insertfile_height;
    }
    $colcode = $arr4[1];
    if ("$colcode" == "01")
    {
        $col = '0xff0xd60x01';
    }
    elseif ("$colcode" == "02")
    {
        $col = '0xee0x760x00';
    }
    elseif ("$colcode" == "03")
    {
        $col = '0x840xde0x00';
    }
    elseif ("$colcode" == "04")
    {
        $col = '0x580x9a0x00';
    }
    elseif ("$colcode" == "05")
    {
        $col = '0x500xc10xfb';
    }
    elseif ("$colcode" == "06")
    {
        $col = '0x000x6f0xcf';
    }
    elseif ("$colcode" == "07")
    {
        $col = '0xff0x980xe3';
    }
    elseif ("$colcode" == "08")
    {
        $col = '0xf30x340xbf';
    }
    elseif ("$colcode" == "09")
    {
        $col = '0xff0x2d0x2d';
    }
    elseif ("$colcode" == "10")
    {
        $col = '0xaf0x0a0x0a';
    }
    elseif ("$colcode" == "11")
    {
        $col = '0xff0xff0xff';
    }
    elseif ("$colcode" == "12")
    {
        $col = '0xc00xc00xc0';
    }
    elseif ("$colcode" == "13")
    {
        $col = '0x370x370x37';
    }
    elseif ("$colcode" == "14")
    {
        $col = '0xfb0xe70xac';
    }
    elseif ("$colcode" == "15")
    {
        $col = '0x970x760x41';
    }
    elseif ("$colcode" == "16")
    {
        $col = '0xc20xea0xff';
    }
    elseif ("$colcode" == "17")
    {
        $col = '0xff0xf10x65';
    }
    elseif ("$colcode" == "18")
    {
        $col = '0xaa0xff0x7d';
    }

    $colour = str_split($col, 4);
    $hex1 = $colour[0];
    $hex2 = $colour[1];
    $hex3 = $colour[2];

    function image_colorize4(&$img, $rgb)
    {
        imageTrueColorToPalette($img, true, 256);
        $numColors = imageColorsTotal($img);
        for ($x = 0;$x < $numColors;$x++)
        {
            list($r, $g, $b) = array_values(imageColorsForIndex($img, $x));
            $grayscale = ($r + $g + $b) / 3 / 0xff;
            imageColorSet($img, $x, $grayscale * $rgb[0], $grayscale * $rgb[1], $grayscale * $rgb[2]);
        }
    }
    $color = array(
        $hex1,
        $hex2,
        $hex3
    );
    $lay4 = "badges/templates/$arr4[0].gif";
    $img = imageCreateFromgif($lay4);
    image_colorize4($img, $color);
    if (file_exists("badges/templates/$arr4[0]_$arr4[0].gif"))
    {
        $olay = imagecreatefromgif("badges/templates/$arr4[0]_$arr4[0].gif");
        imagecopymerge($img, $olay, 0, 0, 0, 0, $h, $w, 100);
        imagecopy($im, $img, $p, $pp, 0, 0, $h, $w);
    }
    else
    {
        imagecopy($im, $img, $p, $pp, 0, 0, $h, $w);
    }
}

$x = 0;
$y = 0;

$orgb = imagecolorallocatealpha($im, 253, 253, 253, 0);
	
for ($x = 0; $x <= 50; $x++) {
	for ($y = 0;$y <= 50; $y++ ) {
				$rgb = imagecolorat($img, $x, $y);
		try {
			$rgb = imagecolorat($im, $x, $y);
			$colors = imagecolorsforindex($im,  $rgb);

			if ($colors['red'] == 255 && $colors['green'] == 255 && $colors['blue'] == 255 && $colors['alpha'] == 0) {
				imagesetpixel($im,$x,$y,$orgb);		
			}
		}
		catch (exception $e) {
			echo $e;
		}
	}
}

imagegif($im);

$badgedata = $_GET['badge'];
$badgedata = str_replace(".gif", "", $badgedata);

if (file_exists("badge-fill/$badgedata.gif"))
{
    imagedestroy($im);
}
else
{
    imagegif($im, "badge-fill/$badgedata.gif");
    imagedestroy($im);
}
?>