function changeSrc(id, path)
{
    document.getElementById(id).src = path;
}
function resizeSrc()
{
    var objs = document.getElementsByTagName('img');
    for(var i = 0; i < objs.length; i++){
        var img = objs[i];
        img.style.maxWidth = '100%';
        img.style.height = 'auto';
    }
}
function changeFontSize(size)
{
   var tfs = '120%';
   var ifs = '100%';
   var tlh = '30px';
   var ilh = '18px';
   switch (size)
    {
          case 110:
                tfs = '110%';
                ifs = '90%';
                tlh = '28px';
                ilh = '16px';
                break;
          case 120:
                tfs = '120%';
                ifs = '100%';
                tlh = '30px';
                ilh = '18px';
                break;
          case 130:
                tfs = '130%';
                ifs = '110%';
                tlh = '34px';
                ilh = '22px';
                break;
          case 140:
                tfs = '140%';
                ifs = '120%';
                tlh = '38px';
                ilh = '26px';
                break;
          case 150:
                tfs = '150%';
                ifs = '130%';
                tlh = '42px';
                ilh = '30px';
                break;
    }
    var pNodes = document.getElementsByTagName('p');
    for (var i = 0; i < pNodes.length; i++) {
        if (pNodes[i].className == 'imgtxt') {
            pNodes[i].style.fontSize = ifs;
            pNodes[i].style.lineHeight = ilh;
        }
        if (pNodes[i].className == 'txt') {
            pNodes[i].style.fontSize = tfs;
            pNodes[i].style.lineHeight = tlh;
        }
    }
}