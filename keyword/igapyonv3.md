[top](../index.html) / [index](index.html) / [target](https://www.igapyon.jp/igapyon/diary/keyword/igapyonv3.html) / [source](https://github.com/igapyon/diary/blob/master/keyword/igapyonv3.src.md) 

igapyonv3
=====================================================================================================
[![いがぴょんの日記](https://www.igapyon.jp/igapyon/diary/images/iga202308_64.jpg "いがぴょん")](https://www.igapyon.jp/igapyon/diary/memo/memoigapyon.html) 日記形式でつづる [いがぴょん](https://www.igapyon.jp/igapyon/diary/memo/memoigapyon.html)コラム ウェブページです。

## igapyonv3

[igapyonv3](igapyonv3.html) は、「いがぴょんの日記ウェブページv3」という日記を記述する目的から作られた、日記執筆者自身の手によって開発された日記システムです。

### URL

* [https://github.com/igapyon/igapyonv3](https://github.com/igapyon/igapyonv3)
* [https://igapyon.github.io/igapyonv3](https://igapyon.github.io/igapyonv3)

### igapyonv3 の利用例

[igapyonv3](igapyonv3.html) の利用例には以下のようなものがあります。

* [https://igapyon.github.io/diary/](https://igapyon.github.io/diary/)
* [https://www.igapyon.jp/i.../index.html](https://www.igapyon.jp/igapyon/diary/index.html)



## [igapyonv3] の特徴

※このコンテンツは [igapyonv3](igapyonv3.html) から <@include /> によって参照されています。

[igapyonv3](igapyonv3.html) は静的サイト／ブログを簡単に素早く実現することができるジェネレータツールです。

* [Markdown](markdown.html) 形式のコンテンツ作成に対応
  * Markdown ソースファイルを入力に、ヘッダ／フッタの展開や index ファイルの自動更新などを実現します。
  * 直接 Markdown を操作するか、あるいはお好みの Markdown エディタを利用してコンテンツを作成することができます。
  * [FreeMarker](freemarker.html) テンプレートエンジンに対応しており、各種ディレクティブによる効率的なコンテンツ作成が可能です。
* 静的コンテンツベース
  * Markdown から html 生成する機能を持っています。
  * [github](github.html) の [gh-pages](gh-pages.html) 上でのブログ公開にも対応しています。
  * インターネットセキュリティ脅威に対する非常に高い耐性を持ち、またサーバーレスアーキテクチャの選択すら可能です。
* インストールがとても簡単
  * Maven セントラルリポジトリで配布されているので、インストールがとても安全で簡単です。[Maven](maven.html) と [Java](java.html) さへインストールされていればすぐに利用できます。
  * Maven プラグインで完結しており、データベースなど他プロダクトは不要です。
  * Maven が動作する環境で igapyonv3-maven-plugin 記述を `pom.xml` ファイルに追加するだけでインストールが完了します。

[igapyonv3](igapyonv3.html) は [OSS](oss.html) アプリケーションであり、ソースコードなどは [github](github.html) 上に公開されています。

* [https://github.com/igapy...aven-plugin](https://github.com/igapyon/igapyonv3-maven-plugin)
* [https://github.com/igapyon/igapyonv3](https://github.com/igapyon/igapyonv3)

Last modified: $Date: 2017-03-04 $


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

### 設定

* `${showSettings()}` : 設定を表示
* `${setVerbose("false")}`
* `${setAuthor("Toshiki Iga")}`
* `${setBaseurl("https://igapyon.github.io/diary")}`
* `${setSourcebaseurl("https://github.com/igapyon/diary/blob/gh-pages")}`

### リンク出力

#### 検索系

* `<@linksearch word="いがぴょん" />`
  * [Search 'いがぴょん' in google](https://www.google.co.jp/#pws=0&q=%E3%81%84%E3%81%8C%E3%81%B4%E3%82%87%E3%82%93)
* `<@linksearch title="いがぴょん検索サイト内" word="いがぴょん" site="https://igapyon.github.io/diary/" />`
  * [いがぴょん検索サイト内](https://www.google.co.jp/#pws=0&q=site:https%3A%2F%2Figapyon.github.io%2Fdiary%2F+%E3%81%84%E3%81%8C%E3%81%B4%E3%82%87%E3%82%93)
* `<@linksearch title="いがぴょんTwitter" word="伊賀敏樹" engine="twitter" />`
  * [いがぴょんTwitter](https://twitter.com/search?q=%23%E4%BC%8A%E8%B3%80%E6%95%8F%E6%A8%B9)

#### SNS系

* `<@linkshare word="${current.title}" tags="igapyon,diary,いがぴょん" />`
  * [Share on Twitter](https://twitter.com/intent/tweet?hashtags=igapyon%2Cdiary%2C%E3%81%84%E3%81%8C%E3%81%B4%E3%82%87%E3%82%93&text=igapyonv3&url=https%3A%2F%2Fwww.igapyon.jp%2Figapyon%2Fdiary%2Fkeyword%2Figapyonv3.html)

#### ナビゲーション系

* `<@linktop />`
  * [top](../index.html)
* `<@linktarget />`
  * [target](https://www.igapyon.jp/igapyon/diary/2017/ig170114.html)
* `<@linksource />`
  * [source](https://github.com/igapyon/diary/blob/master/2017/ig170114.src.md)
* `<@linkprev />`
  * [prev](ig170113.html)
* `<@linknext />`
  * [next](ig170115.html)
* `<@navlist />`
  * [top](../index.html) 
 / [index](index.html) 
 / [prev](ig170113.html) 
 / [next](ig170115.html) 
 / [target](https://www.igapyon.jp/igapyon/diary/2017/ig170114.html) 
 / [source](https://github.com/igapyon/diary/blob/master/2017/ig170114.src.md)

#### その他

* `<@link value="https://www.igapyon.jp/igapyon/diary/index.html" />`
  * [https://www.igapyon.jp/i.../index.html](https://www.igapyon.jp/igapyon/diary/index.html)
* `<@linkdiary date="2017-01-14" />`
  * [2017-01-14 diary: [igapyonv3] の [Markdown] 中で利用可能なカスタム ディレクティブ一覧](https://www.igapyon.jp/igapyon/diary/2017/ig170114.html)
* `<@linkamazon title="JDBC本" dp="4839913935" />`
  * [JDBC本](https://www.amazon.co.jp/exec/obidos/ASIN/4839913935/igapyondiary-22)
* `<@linkmap word="mapテスト" lat="35.6722478" lon="139.7214164" />`
  * [地図で表示](https://openstreetmap.jp/map#zoom=17&lat=35.6722478&lon=139.7214164&layers=00BFF)
* `<@lastmodified date="2017-01-22" />`
  * Last modified: $Date: 2017-01-22 $

### リスト展開

#### RSS系

`<@rssfeed url="https://www.publickey1.jp/atom.xml" maxcount="0" />`

#### [Publickey](https://www.publickey1.jp/)



`<@localrss />`

`<@localyearlist />`

[2024](../2024/index.html)
/ [2023](../2023/index.html)
/ [2022](../2022/index.html)
/ [2021](../2021/index.html)
/ [2020](../2020/index.html)
/ [2019](../2019/index.html)
/ [2018](../2018/index.html)
/ [2017](index.html)
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
* [FreeMarker](../keyword/freemarker.html)
* [github](../keyword/github.html)
* [gh-pages](../keyword/gh-pages.html)
* [Maven](../keyword/maven.html)
* [Java](../keyword/java.html)
* [OSS](../keyword/oss.html)
* [CMS](../keyword/cms.html)


### 取り込み展開

#### ファイル取り込み展開

`<@include file="ig170103.src.md" />`


### 検索

* [Search 'igapyonv3' in Igapyon Diary site](https://www.google.co.jp/#pws=0&q=site:https%3A%2F%2Figapyon.github.io%2Fdiary%2F+igapyonv3)
* [Search 'igapyonv3' in google](https://www.google.co.jp/#pws=0&q=igapyonv3)
* [Search 'igapyonv3' in twitter](https://twitter.com/search?q=%23igapyonv3)

### 日記

* [2017-03-05 diary: [igapyonv3] 最新版 1.5.0 を [Sonatype] 経由で [Maven] Central Repository にリリース](../2017/ig170305.html)
* [2017-03-04 diary: [igapyonv3] URLの自動リンク機能の実装方式をディレクティブ式に変更](../2017/ig170304.html)
* [2017-03-03 diary: [igapyonv3] の特徴](../2017/ig170303.html)
* [2017-03-02 diary: [igapyonv3] の依存ライブラリ](../2017/ig170302.html)
* [2017-02-13 diary:  [igapyonv3] で [gh-pages] に日記を作成するときの Getting Started【展開版】](../2017/ig170213.html)
* [2017-02-12 diary: [igapyonv3] で [gh-pages] に日記を作成するときの Getting Started](../2017/ig170212.html)
* [2017-02-10 diary: [github] に日記を書いて github 学習のアイデア [igapyonv3]](../2017/ig170210.html)
* [2017-02-06 diary: [igapyonv3] ファイルの拡張子の考え方を調整実験中](../2017/ig170206.html)
* [2017-02-05 diary: [igapyonv3] ファイル拡張子の調整を検討中](../2017/ig170205.html)
* [2017-02-03 diary: [Maven] [Sonatype] 上の [igapyonv3] リポジトリ所在地メモ](../2017/ig170203.html)
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

* ホームページ更新者: 伊賀 敏樹 / Tosiki Iga
* [Diary](https://www.igapyon.jp/igapyon/diary/) / [Facebook](https://www.facebook.com/igapyon) / [LinkedIn](https://www.linkedin.com/in/toshikiiga) / [GitHub](https://github.com/igapyon) / [Qiita](https://qiita.com/igapyon) / [Mastodon](https://social.vivaldi.net/@igapyon) / [X/Twitter](https://twitter.com/ToshikiIga) / [Amazon](https://www.amazon.co.jp/%E4%BC%8A%E8%B3%80-%E6%95%8F%E6%A8%B9/e/B004LTQWCQ) / 
[Share on Twitter](https://twitter.com/intent/tweet?hashtags=igapyon%2Cdiary%2C%E3%81%84%E3%81%8C%E3%81%B4%E3%82%87%E3%82%93%2Cigapyonv3%2CMarkdown%2CFreemarker%2Cgithub%2Cgh-pages%2CMaven%2CJava%2COSS%2CCMS&text=igapyonv3&url=https%3A%2F%2Fwww.igapyon.jp%2Figapyon%2Fdiary%2Fkeyword%2Figapyonv3.html) / [top](../index.html) / [いがぴょんについて](https://www.igapyon.jp/igapyon/diary/memo/memoigapyon.html) / [Powered by Igapyonv3](https://github.com/igapyon/igapyonv3)
* 本サイトの見解は、私 個人のものであり、株式会社レザボア・コンサルティング は当個人的見解に一切責任を持ちません。 
