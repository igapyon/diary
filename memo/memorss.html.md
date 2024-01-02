[top](../index.html) / [index](index.html) / [target](https://www.igapyon.jp/igapyon/diary/memo/memorss.html) / [source](https://github.com/igapyon/diary/blob/master/memo/memorss.src.md) 

資料: RDF/RSSについて , いがぴょんの日記ウェブページ RDF/RSS一覧
=====================================================================================================
[![いがぴょんの日記](https://www.igapyon.jp/igapyon/diary/images/iga202308_64.jpg "いがぴょん")](https://www.igapyon.jp/igapyon/diary/memo/memoigapyon.html) 日記形式でつづる [いがぴょん](https://www.igapyon.jp/igapyon/diary/memo/memoigapyon.html)コラム ウェブページです。

[old-v2](memorss-orig.html)

RDF/RSSに関するメモ および いがぴょんの日記関連RDF/RSSの一覧(抜粋)

## 資料: RDF/RSSについて , いがぴょんの日記ウェブページ RDF/RSS一覧

[いがぴょんのウェブページトップへ戻る](../../index.html)

## RDF や RSS, FOAF について

おおざっぱに説明すると…もともと ウェブサイトの要約を作成する技術で RSSというのがありました。これを汎用化したものがRDFです。

* 現時点でも RDFのもっともポピュラーな利用方法は RSS (RDF Site Summary)です。
  
* [FOAF](memofoaf.html) という RDFの別の興味深い利用方法もあります。私は FOAFを電子名刺として認識しています。

RDFやRSS, FOAFなどについて詳しく知るためには、[神崎正英](http://www.kanzaki.com/)（かんざきまさひで）さんの記事がとても良い情報です。日本で RSSやFOAFに手を出す人は 必ず [神崎正英](http://www.kanzaki.com/)さんの情報に接することでしょう。(ほぼ無意識のうちにたどり着いてしまうのです！)

* RSS -- サイト情報の要約と公開
  [http://www.kanzaki.com/docs/sw/rss.html](http://www.kanzaki.com/docs/sw/rss.html)
  
* FOAF -- メタデータによる知人ネットワークの表現
  [http://www.kanzaki.com/docs/sw/foaf.html](http://www.kanzaki.com/docs/sw/foaf.html)
  
* RDF -- リソース表現のフレームワーク
  [http://www.kanzaki.com/docs/sw/rdf-model.html](http://www.kanzaki.com/docs/sw/rdf-model.html)

また RSS - Wiki にも日本語によるコンパクトな (2003.12.16時点) 記事があります。

* [http://www.hyuki.com/yukiwiki/wiki.cgi?RSS](http://www.hyuki.com/yukiwiki/wiki.cgi?RSS)

## 日記インディックスのRDF/RSS

私の日記コンテンツに対する RDF/RSS は、基本的に あるタイミングにて静的に作成されて公開されています。

* 更新日時順
  RDF0.91 : [http://homepage2.nifty.com/igat/igapyon/diary/rss/idxupdate.rss0.9.xml](http://homepage2.nifty.com/igat/igapyon/diary/rss/idxupdate.rss0.9.xml)
  RDF1.0 : [http://homepage2.nifty.com/igat/igapyon/diary/rss/idxupdate.rss1.0.xml](http://homepage2.nifty.com/igat/igapyon/diary/rss/idxupdate.rss1.0.xml)
  
* 日記を全て
  RDF0.91 : [http://homepage2.nifty.com/igat/igapyon/diary/rss/idxall.rss0.9.xml](http://homepage2.nifty.com/igat/igapyon/diary/rss/idxall.rss0.9.xml)
  RDF1.0 : [http://homepage2.nifty.com/igat/igapyon/diary/rss/idxall.rss1.0.xml](http://homepage2.nifty.com/igat/igapyon/diary/rss/idxall.rss1.0.xml)

これらRSSを提供することは RSS実験の上でとても有意義なものでした。

なお、私の日記におけるRSS提供は 2001年02月20日から行っています。

* いがぴょんの日記(v1): 2001/02/20 日記: いがぴょんの日記 RDF Site Summary 試行開始
  [http://www.nttd-bb.com/solution/igapyon1/ig010220.html](http://www.nttd-bb.com/solution/igapyon1/ig010220.html)

## 世間の方々が提供しているRSS

いろんな方々がいろんなRSSを公開されています。これの一覧を知るには 下記のサイトが良いでしょう。

* rss-jp.net: 日本で配布されているRSS/RDF
  [http://rss-jp.net/rss_list.html](http://rss-jp.net/rss_list.html)

特に気になっている 公式RSS/RDFは下記です。

* アサヒ･コム速報ニュースのRSS/RDF (via [YAMADAS現更新履歴](http://d.hatena.ne.jp/yomoyomo/))[http://www.asahi.com/information/rss/index.html](http://www.asahi.com/information/rss/index.html)
  全ジャンルの見出しと記事リンクを提供。すばらしい時代が到来したものです。

IT技術者必見サイトについても、純正RDF/RSSが提供され出しました。ITのためのIT技術適用がなされる。これはすばらしい傾向です。

* CNET Japan 純正RSS
  [http://japan.cnet.com/rss/index.rdf](http://japan.cnet.com/rss/index.rdf)
  
* Sun Java 純正RSS
  [http://servlet.java.sun.com/syndication/rss_java_highlights-PARTNER-20.xml](http://servlet.java.sun.com/syndication/rss_java_highlights-PARTNER-20.xml)
  
* [結城浩](http://www.hyuki.com/)さんの textfile.org
  [http://www.hyuki.com/tf/?rss](http://www.hyuki.com/tf/?rss)
  
* [神崎正英](http://www.kanzaki.com/)さんの The Web KANZAKI - Updates as RSS
  [http://www.kanzaki.com/info/rss.rdf](http://www.kanzaki.com/info/rss.rdf)
  
* オンライン書店bk1 のランキング [コンピュータ] (2003.11.30追記)
  [http://breeder.bk1.jp/cgi-bin/rss/rdf.cgi?aid=p-igapyon64766&amp;v=1.0&amp;s=01070000](http://breeder.bk1.jp/cgi-bin/rss/rdf.cgi?aid=p-igapyon64766&amp;v=1.0&amp;s=01070000)
  入り口: [http://breeder.bk1.jp/rss/create.html](http://breeder.bk1.jp/rss/create.html)
  
* MYCOM PC WEB
  [http://pcweb.mycom.co.jp/haishin/rss/index.rdf](http://pcweb.mycom.co.jp/haishin/rss/index.rdf)

## 世間HTMLのRDF/RSS化実験

世間のHTMLをRDF/RSS化する実験です。
2005.01.31 動作テスト検証が目的でしたが、RSSの普及に伴い、この実験は終了しました。

## RSSを自作したい方向けサンプルソースコード (Java)

拙著『Javaプログラミング[アプリケーション編] ステップアップラーニング』の第五章と番外編を通して学ぶと、RSS作成がごく普通に理解できるようになっています。RSS作成の入門を考えられている方はぜひ ご覧下さい！

* [amazon.co.jp: 4774116122](http://www.amazon.co.jp/exec/obidos/ASIN/4774116122/igapyondiary-22)

RDF/RSSが流行ると、私の本が 売れていく… かもっ (笑)

## 関連するリソース

* CNET Japan: マイクロソフト、RSSを強力にプッシュ--IEとWindowsでサポートへ
  [http://japan.cnet.com/news/media/story/0,2000047715,20084752,00.htm](http://japan.cnet.com/news/media/story/0,2000047715,20084752,00.htm)
  2005.06.27追記 RSSは MicrosoftがOSの宣伝文句のひとつとして利用するまでに至りました。

## 関連する日記

* [2003/12/30 日記: 2003年を振り返りました](../2003/ig031230.html)

## 更新履歴

* 2004/03/03 更新 アサヒ・コムがRSS/RDFを公開開始！
  
* 2003/06/20 更新 文章を少しマトモに加工してみる。
  
* 2002/11/06 更新
  
* 2001/10/25 新規作成

----------------------------------------------------------------------------------------------------

## この日記について

* ホームページ更新者: 伊賀 敏樹 / Tosiki Iga
* [Diary](https://www.igapyon.jp/igapyon/diary/) / [Facebook](https://www.facebook.com/igapyon) / [LinkedIn](https://www.linkedin.com/in/toshikiiga) / [GitHub](https://github.com/igapyon) / [Qiita](https://qiita.com/igapyon) / [Mastodon](https://social.vivaldi.net/@igapyon) / [Post](https://post.news/igapyon) / [Twitter](https://twitter.com/ToshikiIga) / [Amazon](https://www.amazon.co.jp/%E4%BC%8A%E8%B3%80-%E6%95%8F%E6%A8%B9/e/B004LTQWCQ) / [OSDN](https://ja.osdn.net/users/iga/)
[Share on Twitter](https://twitter.com/intent/tweet?hashtags=igapyon%2Cdiary%2C%E3%81%84%E3%81%8C%E3%81%B4%E3%82%87%E3%82%93&text=%E8%B3%87%E6%96%99%3A+RDF%2FRSS%E3%81%AB%E3%81%A4%E3%81%84%E3%81%A6+%2C+%E3%81%84%E3%81%8C%E3%81%B4%E3%82%87%E3%82%93%E3%81%AE%E6%97%A5%E8%A8%98%E3%82%A6%E3%82%A7%E3%83%96%E3%83%9A%E3%83%BC%E3%82%B8+RDF%2FRSS%E4%B8%80%E8%A6%A7&url=https%3A%2F%2Fwww.igapyon.jp%2Figapyon%2Fdiary%2Fmemo%2Fmemorss.html) / [top](../index.html) / [いがぴょんについて](https://www.igapyon.jp/igapyon/diary/memo/memoigapyon.html) / [Powered by Igapyonv3](https://github.com/igapyon/igapyonv3)
* 本サイトの見解は、私 個人のものであり、株式会社レザボア・コンサルティング は当個人的見解に一切責任を持ちません。 
