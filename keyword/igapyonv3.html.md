[top](../index.html) / [target](https://igapyon.github.io/diary/keyword/igapyonv3.html) / [source](https://github.com/igapyon/diary/blob/gh-pages/keyword/igapyonv3.html.src.md) 

igapyonv3
=====================================================================================================
[![いがぴょん画像(小)](https://igapyon.github.io/diary/images/iga200306s.jpg "いがぴょん")](https://igapyon.github.io/diary/memo/memoigapyon.html) 日記形式でつづる [いがぴょん](https://igapyon.github.io/diary/memo/memoigapyon.html)コラム ウェブページです。

[index](https://igapyon.github.io/diary/keyword/index.html)
/ [target](https://igapyon.github.io/diary/keyword/igapyonv3.html) 
/ [source](https://github.com/igapyon/diary/blob/gh-pages/keyword/igapyonv3.html.src.md)

## igapyonv3

[igapyonv3](igapyonv3.html) は、「いがぴょんの日記ウェブページv3」という日記を記述する目的から作られた、日記執筆者自身の手によって開発された日記システムです。

### URL

* [https://github.com/igapyon/igapyonv3](https://github.com/igapyon/igapyonv3)
* [https://igapyon.github.io/igapyonv3](https://igapyon.github.io/igapyonv3)

### igapyonv3 の利用例

[igapyonv3](igapyonv3.html) の利用例には以下のようなものがあります。

* [https://igapyon.github.io/diary/](https://igapyon.github.io/diary/)
* [http://www.igapyon.jp/ig.../index.html](http://www.igapyon.jp/igapyon/diary/index.html)

### 検索

* [Search 'igapyonv3' in Igapyon Diary site](https://www.google.co.jp/#pws=0&q=site:https%3A%2F%2Figapyon.github.io%2Fdiary%2F+igapyonv3)
* [Search 'igapyonv3' in google](https://www.google.co.jp/#pws=0&q=igapyonv3)
* [Search 'igapyonv3' in twitter](https://twitter.com/search?q=%23igapyonv3)



## [igapyonv3] の歴史

※このコンテンツは [igapyonv3](igapyonv3.html) から <@include /> によって参照されています。

[igapyonv3](igapyonv3.html) は約20年の歴史を持つ日記ジェネレータシステムです。最新版はバージョン3です。

* 日記ジェネレータのバージョン1 (v1) は 1997頃に作成されました。
  * コンテンツは html で記述し、html ファイルを入力に html ファイルを生成
* 日記ジェネレータのバージョン2 (v2) は 2001頃に作成されました。
  * コンテンツは html で記述し、html ファイルを入力に html ファイルを生成
  * 概ね OSS により構築されていました。
* 日記ジェネレータのバージョン3 (v3) は 2017頃に作成されました。
  * コンテンツは [Markdown](markdown.html) で記述し、md ファイルを入力に md ファイルおよび html ファイルを生成
  * 基本的に OSS により構築されており、またソースコードは公開されています。


## [igapyonv3] のソフトウェア構造

現時点の [igapyonv3](igapyonv3.html) のソフトウェア構造に関するメモをします。

※このコンテンツは [igapyonv3](igapyonv3.html) から `<@include />` によって参照されています。

## 全体的な構造

* [Markdown](markdown.html) ファイルを中心とした [CMS](cms.html) システムです。
  * コンテンツを [Markdown](markdown.html) で書くだけです。
  * 生成後のコンテンツは [github](github.html) 上の [gh-pages](gh-pages.html) 上で公開することが可能になっています。
  * テンプレートエンジンに [FreeMarker](freemarker.html) を採用しています。
  * [igapyonv3](igapyonv3.html) 向けの [FreeMarker](freemarker.html) カスタムディレクティブが組み込まれており、例えば日記インデックスファイルを自動生成可能であるなど、日記執筆が極めてはかどります。
* ソフトウェアに関すること
  * 基本的に [OSS](oss.html) のみで構成されています。
  * 静的コンテンツを生成する手法を採用しています。アプリケーションサーバーなどの動的サーバーは不要です。
  * [Java](java.html) 言語で記述されており、実行には [Maven](maven.html) が必要です。
* 導入による技術的な副作用がとても小さいです。
  * 基本的にテキストファイルだけで動作します。
  * 実行に RDBMS などのミドルウェア類は不要です。
  * [Markdown](markdown.html) で完結しているため、他システムへの移行や他システムからの移行が簡単です。


## [igapyonv3] の [Markdown] 中で利用可能なカスタム ディレクティブ一覧

[igapyonv3](igapyonv3.html) の [Markdown](markdown.html) ファイルの中で利用することができるカスタム ディレクティブ一覧を以下にメモしておきます。

※このコンテンツは [igapyonv3](igapyonv3.html) から `<@include />` によって参照されています。

### リンク出力

#### 検索系

* `<@linksearch word="いがぴょん" />`
  * [Search 'いがぴょん' in google](https://www.google.co.jp/#pws=0&q=%E3%81%84%E3%81%8C%E3%81%B4%E3%82%87%E3%82%93)
* `<@linksearch title="いがぴょん検索サイト内" word="いがぴょん" site="https：//igapyon.github.io/diary/" />`
  * [いがぴょん検索サイト内](https://www.google.co.jp/#pws=0&q=site:https%3A%2F%2Figapyon.github.io%2Fdiary%2F+%E3%81%84%E3%81%8C%E3%81%B4%E3%82%87%E3%82%93)
* `<@linksearch title="いがぴょんTwitter" word="伊賀敏樹" engine="twitter" />`
  * [いがぴょんTwitter](https://twitter.com/search?q=%23%E4%BC%8A%E8%B3%80%E6%95%8F%E6%A8%B9)

#### SNS系

* `<@linkshare word="${current.title}" tags="igapyon,diary,いがぴょん" />`
  * [Share on Twitter](https://twitter.com/intent/tweet?hashtags=igapyon%2Cdiary%2C%E3%81%84%E3%81%8C%E3%81%B4%E3%82%87%E3%82%93&text=igapyonv3&url=https%3A%2F%2Figapyon.github.io%2Fdiary%2Fkeyword%2Figapyonv3.html)

#### ナビゲーション系

* `<@linktop />`
  * [top](../index.html)
* `<@linktarget />`
  * [target](https://igapyon.github.io/diary/2017/ig170114.html)
* `<@linksource />`
  * [source](https://github.com/igapyon/diary/blob/gh-pages/2017/ig170114.html.src.md)
* `<@linkprev />`
  * [prev](ig170113.html)
* `<@linknext />`
  * [next](ig170115.html)
* `<@navlist />`
  * [top](../index.html) 
 / [index](index.html) 
 / [prev](ig170113.html) 
 / [next](ig170115.html) 
 / [target](https://igapyon.github.io/diary/2017/ig170114.html) 
 / [source](https://github.com/igapyon/diary/blob/gh-pages/2017/ig170114.html.src.md)

#### その他

* `<@linkdiary date="2017-01-14" />`
  * [2017-01-14 diary: [igapyonv3] の [Markdown] 中で利用可能なカスタム ディレクティブ一覧](https://igapyon.github.io/diary/2017/ig170114.html)
* `<@linkamazon title="JDBC本" dp="4839913935" />`
  * [JDBC本](https://www.amazon.co.jp/exec/obidos/ASIN/4839913935/igapyondiary-22)
* `<@linkmap word="mapテスト" lat="35.6722478" lon="139.7214164" />`
  * [地図で表示](https://openstreetmap.jp/map#zoom=17&lat=35.6722478&lon=139.7214164&layers=00BFF)
* `<@lastmodified date="2017-01-22" />`
  * Last modified: $Date: 2017-01-22 $

### リスト展開

#### RSS系

`<@rssfeed url="http：//www.publickey1.jp/atom.xml" maxcount="0" />`

#### [Publickey](http://www.publickey1.jp/)



`<@localrss />`

* [2017-01-28 diary: [FreeMarker] オブジェクトの boolean 値による if 分岐](ig170128.html)
* [2017-01-27 diary: [Ant] sf.jp の URL を osdn に置き換え](ig170127.html)
* [2017-01-26 diary: [Maven] 中の [Ant] 記述から [Java] アプリを実行するシンプルサンプル](ig170126.html)
* [2017-01-25 diary: [igapyonv3] 日記システム UI 考](ig170125.html)
* [2017-01-24 diary: [Mac] に VirtualBox をインストール、そして [Ubuntu] [Java] [Eclipse] 導入](ig170124.html)
* [2017-01-23 diary: [English] 超基本ビジネス英単語](ig170123.html)
* [2017-01-22 diary: [igapyonv3] システムの「Twitter でシェア」がらみを改良](ig170122.html)
* [2017-01-21 diary: [Ant] 正規表現 [regex] を Ant の中で利用する方法](ig170121.html)
* [2017-01-20 diary: [Java] XPath のシンプルサンプル](ig170120.html)
* [2017-01-19 diary: MacBook Air の macOS 再インストール手順メモ](ig170119.html)
* [2017-01-18 diary: [Java] TagSoup を利用した HTML 正常化のシンプルサンプル](ig170118.html)
* [2017-01-17 diary: [Java] 正規表現 `regex` の少しだけ応用のメモ](ig170117.html)
* [2017-01-16 diary: [Java] 正規表現 `regex` による文字列処理のメモ](ig170116.html)
* [2017-01-15 diary: [igapyonv3] の歴史](ig170115.html)
* [2017-01-14 diary: [igapyonv3] の [Markdown] 中で利用可能なカスタム ディレクティブ一覧](ig170114.html)
* [2017-01-13 diary: [igapyonv3] のソフトウェア構造](ig170113.html)
* [2017-01-12 diary: [Shell] シェルから内容込みでファイルを作成する方法メモ](ig170112.html)
* [2017-01-11 diary: [igapyonv3] PegDown が EOL とのことらしい](ig170111.html)
* [2017-01-10 diary: Twitter シェアの機能を確認中](ig170110.html)
* [2017-01-09 diary: 2017年正月休み成果 [igapyonv3], [gh-pages], [Maven], [FreeMarker]](ig170109.html)
* [2017-01-08 diary: 日記ジェネレータ [igapyonv3] のキーワードシステム構築中](ig170108.html)
* [2017-01-07 diary: [FreeMarker] のカスタムディレクティブ秀逸](ig170107.html)
* [2017-01-06 diary: [FreeMarker] Java 処理を伴うカスタムタグのシンプルメモ](ig170106.html)
* [2017-01-05 diary: [FreeMarker] の処理解釈を抑止する方法](ig170105.html)
* [2017-01-04 diary: [github] gh-pages のビルドエラーを体験 → [jekyll] 問題](ig170104.html)
* [2017-01-03 diary: 「いがぴょんの日記v3」システム [igapyonv3] に機能追加中](ig170103.html)
* [2017-01-02 diary: [Maven] によるシンプル Java プロジェクトサンプルの作成手順](ig170102.html)
* [2017-01-01 diary: [FreeMarker] シンプルサンプル](ig170101.html)


`<@localyearlist />`

[2017](index.html)
/ [2016](../2016/index.html)
/ [2015](../2015/index.html)
/ [2014](../2014/index.html)
/ [2013](../2013/index.html)
/ [2012](../2012/index.html)
/ [2011](../2011/index.html)
/ [2010](../2010/index.html)
/ [2009](../2009/index.html)
/ [2008](../2008/index.html)
/ [2007](../2007/index.html)
/ [2006](../2006/index.html)
/ [2005](../2005/index.html)
/ [2004](../2004/index.html)
/ [2003](../2003/index.html)
/ [2002](../2002/index.html)
/ [2001](../2001/index.html)
/ [2000](../2000/index.html)
/ [1998](../1998/index.html)
/ [1997](../1997/index.html)
/ [1996](../1996/index.html)
/ [ALL](../idxall.html)


## 登場キーワード

* [igapyonv3](../keyword/igapyonv3.html)
* [Markdown](../keyword/markdown.html)
* [CMS](../keyword/cms.html)
* [github](../keyword/github.html)
* [gh-pages](../keyword/gh-pages.html)
* [FreeMarker](../keyword/freemarker.html)
* [OSS](../keyword/oss.html)
* [Java](../keyword/java.html)
* [Maven](../keyword/maven.html)


### 取り込み展開

#### ファイル取り込み展開

`<@include file="ig170103.html.src.md" />`

## 「いがぴょんの日記v3」システム [igapyonv3] に機能追加中

いがぴょんの日記v3 システム [igapyonv3](igapyonv3.html) について、すこしずつ機能追加してみています。

* `favicon` を配置してみました。しかし、うまくいっていないようです。
  * favicon 作成には [https://ao-system.net/fa...ngenerator/](https://ao-system.net/favicongenerator/) サービスを利用させていただきました。
* すべての年にインデックスファイルを配置してみました。
* 日記リーフについては、ソースへの自動リンク生成を付与してみました。



### 日記

* [2017-01-25 diary: [igapyonv3] 日記システム UI 考](../2017/ig170125.html)
* [2017-01-22 diary: [igapyonv3] システムの「Twitter でシェア」がらみを改良](../2017/ig170122.html)
* [2017-01-15 diary: [igapyonv3] の歴史](../2017/ig170115.html)
* [2017-01-14 diary: [igapyonv3] の [Markdown] 中で利用可能なカスタム ディレクティブ一覧](../2017/ig170114.html)
* [2017-01-13 diary: [igapyonv3] のソフトウェア構造](../2017/ig170113.html)
* [2017-01-11 diary: [igapyonv3] PegDown が EOL とのことらしい](../2017/ig170111.html)
* [2017-01-09 diary: 2017年正月休み成果 [igapyonv3], [gh-pages], [Maven], [FreeMarker]](../2017/ig170109.html)
* [2017-01-08 diary: 日記ジェネレータ [igapyonv3] のキーワードシステム構築中](../2017/ig170108.html)
* [2017-01-03 diary: 「いがぴょんの日記v3」システム [igapyonv3] に機能追加中](../2017/ig170103.html)
* [2016-12-30 diary: 「いがぴょんの日記ウェブページv3」日記システム [igapyonv3] の試作中](../2016/ig161230.html)
* [2015-07-24 diary: [igapyonv3] IgapyonMd2Html: [Markdown] `*.md` から [Bootstrap] 装飾付きHtml `*.html` への変換ツール](../2015/ig150724.html)



----------------------------------------------------------------------------------------------------

## この日記について

[Share on Twitter](https://twitter.com/intent/tweet?hashtags=igapyon%2Cdiary%2C%E3%81%84%E3%81%8C%E3%81%B4%E3%82%87%E3%82%93%2Cigapyonv3%2CMarkdown%2CCMS%2Cgithub%2Cgh-pages%2CFreeMarker%2COSS%2CJava%2CMaven&text=igapyonv3&url=https%3A%2F%2Figapyon.github.io%2Fdiary%2Fkeyword%2Figapyonv3.html) / [top](../index.html) / [いがぴょんについて](https://igapyon.github.io/diary/memo/memoigapyon.html) / [Diary Generator](https://github.com/igapyon/igapyonv3)
