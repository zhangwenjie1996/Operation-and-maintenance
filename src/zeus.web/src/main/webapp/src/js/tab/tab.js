window.onload = function () {
    function $(id) {
        return document.getElementById(id)
    }

    window.onresize = function () {
        step = 0;
        if (parseFloat(menu.offsetWidth) >= parseFloat(inner.offsetWidth)) {
            leftArrow.style.display = 'block';
            rightArrow.style.display = 'block';
            utils.addClass($('inner'), 'change');
        } else {
            leftArrow.style.display = 'none';
            rightArrow.style.display = 'none';
            utils.removeClass($('inner'), 'change');
            utils.css(menu, {"left": 0});
        }
    };
    var topTags = $('topTags'), inner = $('inner');
    var menu = $("topTags").getElementsByTagName("ul")[0];//???????????
    var tags = menu.getElementsByTagName("li");//???????
    var ck = utils.getElementsByClass('one');//?????
    var eachW = 120;
    var step = 0, o;
    var leftArrow = utils.getElementsByClass('left-arrow')[0],
        rightArrow = utils.getElementsByClass('right-arrow')[0];
    var iframe, iframeArray = document.getElementsByTagName('iframe');
    var winH = document.documentElement.clientHeight || document.body.clientHeight,
        winW = document.documentElement.offsetWidth || document.body.offsetWidth,
        navH = document.getElementsByClassName('navbar')[0].scrollHeight,
        topH = document.getElementById('top').offsetHeight;
    var curH = winH - navH - topH;

//?????????????±??
    for (var i = 0; i < ck.length; i++) {
        ~function (i) {
            ck[i].onclick = function () {
                $("welcome").style.display = "none";//???????????
                clearMenu();
                this.style.background = "#e6f3ff";
                //页卡为空时在后面追加
                if ($("p" + i) == null) {
                    openNew(i, this.innerText);//?????????????
                    if (parseFloat(menu.offsetWidth) >= parseFloat(inner.offsetWidth)) {
                        leftArrow.style.display = 'block';
                        rightArrow.style.display = 'block';
                        utils.addClass($('inner'), 'change');
                        console.log("点击左侧菜单右边顶部菜单超出滚动" + step);
                        zwjAnimate(menu, {left: -(parseFloat(menu.offsetWidth) - parseFloat(inner.offsetWidth))}, 500);
                    }
                    clearStyle();
                    $("p" + i).style.backgroundColor = "white";
                    $("p" + i).style.color = "#5fa2dd";
                    //$("c" + i).style.display = "block";
                    clearContent();
                    //$("c" + i).style.display = "block";
                    iframe = document.createElement('iframe');//动态创建框架
                    iframe.setAttribute("id", i);
                    //var thisId = window.location.hash;
                    iframe.src = utils.children(this, "a")[0].getAttribute("data-attr");  //框架中加载的页面
//                    iframe.style.height = curH+"px";
                    $("content").appendChild(iframe);
                    //parseInt(iframe.getAttribute("id")) === i ? iframe.style.display = "block" : null;
                }else{
                    //页卡存在时运动到其位置
                    o = $("p" + i).offsetLeft;
                    //页卡存在时运动到其位置的判断
                    if (parseFloat(menu.offsetWidth) > parseFloat(inner.offsetWidth)) {
                        if (o >= parseFloat(inner.offsetWidth)) {
                            zwjAnimate(menu, {left: -o + parseFloat(inner.offsetWidth) - eachW}, 500);
                        } else {
                            zwjAnimate(menu, {left: 0}, 500);
                        }
                    } else {
                        zwjAnimate(menu, {left: 0}, 500);
                    }
                    clearStyle();
                    $("p" + i).style.backgroundColor = "white";
                    $("p" + i).style.color = "#5fa2dd";
                    clearContent();
                    console.log(parseInt(iframe.getAttribute("id")));
                    for (var a = 0; a < iframeArray.length; a++) {
                        iframeArray[a].getAttribute("id") == i ? iframeArray[a].style.display = "block" : null
                    }
                    //parseInt(iframe.getAttribute("id")) === i ? iframe.style.display = "block" : iframe.style.display = "none";
                }
                }

        }(i);

    }

//??????
    function openNew(id, name) {
        var tagMenu = document.createElement("li");
        tagMenu.id = "p" + id;
        tagMenu.innerHTML = name + " " + "<span class='dacha fa fa-times'></span>";
//??????
//        tagMenu.onmouseover = function () {
//            clearStyle();
//            tagMenu.style.backgroundColor = "#5596d0";
//            tagMenu.style.color = "white";
//        };
        tagMenu.onclick = function (evt) {
            clearMenu();
            ck[id].style.background = "#e6f3ff";
            clearStyle();
            tagMenu.style.backgroundColor = "#ffffff";
            tagMenu.style.color = "#5fa2dd";
            clearContent();
            for (var a = 0; a < iframeArray.length; a++) {
                iframeArray[a].getAttribute("id") == id ? iframeArray[a].style.display = "block" : null
            }
        };
//关闭相应页卡
        tagMenu.getElementsByTagName("span")[0].onclick = function (evt) {
            evt = (evt) ? evt : ((window.event) ? window.event : null);
            if (evt.stopPropagation) {
                evt.stopPropagation()
            } //???opera??Safari??????;
            o = this.parentNode.offsetLeft + this.parentNode.offsetWidth;
            if (parseFloat(menu.offsetWidth) - eachW <= parseFloat(inner.offsetWidth)) {
                leftArrow.style.display = 'none';
                rightArrow.style.display = 'none';
                utils.removeClass($('inner'), 'change');
                zwjAnimate(menu, {left: 0}, 500);
            } else {
                zwjAnimate(menu, {left: -(parseFloat(menu.offsetWidth) - parseFloat(inner.offsetWidth) - eachW)}, 500);
            }
            this.parentNode.parentNode.removeChild(tagMenu);
            var count = tags.length;
            utils.css(menu, "width", count * eachW);//?????????
//?????????????????????????????????????
            if (tags.length - 1 >= 1) {
                clearStyle();
                tags[tags.length - 1].style.backgroundColor = "white";
                tags[tags.length - 1].style.color = "#5fa2dd";
                clearContent();
                var cc = tags[tags.length - 1].id.split("p");
                for (var a = 0; a < iframeArray.length; a++) {
                    iframeArray[a].getAttribute("id") == cc[1] ? iframeArray[a].style.display = "block" : null;
                }
                //$("c" + cc[1]).style.display = "block";
                clearMenu();
                ck[cc[1]].style.background = "#e6f3ff";
            }
            else {
                clearContent();
                clearMenu();
                $('home').style.backgroundColor = "#ffffff";
                $('home').style.color = "#5fa2dd";
                $("welcome").style.display = "block";
                //zwjAnimate(menu, {left: 0}, 500);
            }
        };
        menu.appendChild(tagMenu);
        var count = tags.length;
        utils.css(menu, "width", count * eachW);
        var tarLeft;
        leftArrow.onclick = function () {
            var curLeft = utils.css(menu, "left");
            tarLeft = curLeft + parseFloat(inner.offsetWidth);
            // tarLeft >= 0 ? tarLeft = 0: null;
            if (tarLeft >= 0) {
                tarLeft = 0;
                utils.addClass(this, 'opa');
            }
            utils.removeClass(rightArrow, 'opa');
            console.log(tarLeft);
            zwjAnimate(menu, {left: tarLeft}, 500);
        };
        rightArrow.onclick = function () {
            var curLeft = utils.css(menu, "left");
            tarLeft = curLeft - parseFloat(inner.offsetWidth);
            var maxLeft = parseFloat(menu.offsetWidth) - parseFloat(inner.offsetWidth);
            if (Math.abs(tarLeft) >= maxLeft) {
                tarLeft = -maxLeft;
                utils.addClass(this, 'opa');
            }
            utils.removeClass(leftArrow, 'opa');
            zwjAnimate(menu, {left: tarLeft}, 500);
        };

    }

//?????????
    function clearMenu() {
        for (i = 0; i < ck.length; i++) {
            ck[i].style.background = "white";
        }
    }

//?????????
    function clearStyle() {
        for (i = 0; i < tags.length; i++) {
            menu.getElementsByTagName("li")[i].style.backgroundColor = "#5fa2dd";
            menu.getElementsByTagName("li")[i].style.color = "white";
        }
    }

//???????
    function clearContent() {
        for (i = 0; i < iframeArray.length; i++) {

            iframeArray[i].style.display = "none"
        }
    }
};

