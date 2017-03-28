[top](../index.html) / [index](index.html) / [target](https://igapyon.github.io/diary/memo/memojavastyle.html) / [source](https://github.com/igapyon/diary/blob/master/memo/memojavastyle.src.md) 

資料: Java言語ソースファイルのスタイルおよび調整ツール
=====================================================================================================
[![いがぴょん画像(小)](https://igapyon.github.io/diary/images/iga200306s.jpg "いがぴょん")](https://igapyon.github.io/diary/memo/memoigapyon.html) 日記形式でつづる [いがぴょん](https://igapyon.github.io/diary/memo/memoigapyon.html)コラム ウェブページです。

[old-v2](memojavastyle-orig.html)

Java言語ソースファイルのスタイル整形に関するメモ。astyleやcheckstyleなどのメモ書きが含まれます。

## 資料: Java言語ソースファイルのスタイルおよび調整ツール

[いがぴょんのウェブページトップへ戻る](../../index.html)

## Java言語コーディング規約

そもそも Java言語コーディング規約にまつわるものとして、下記があります。(そしてこの２つが有名です)

* Java言語コーディング規約
  [http://www.tcct.zaq.ne.jp/ayato/programming/java/codeconv_jp/](http://www.tcct.zaq.ne.jp/ayato/programming/java/codeconv_jp/)
  Java Code Conventions の沼田哲史さんの手による日本語訳
  
* 頑健なJavaプログラムの書き方(Writing Robust Java Code 日本語訳)
  [http://www.alles.or.jp/~torutk/oojava/codingStandard/](http://www.alles.or.jp/~torutk/oojava/codingStandard/)
  高橋徹さんの手による日本語訳

オマケ

* 沼田哲史 (NUMATA Satoshi) さんのページ
  [http://numata.aquasky.jp/](http://numata.aquasky.jp/)

以下はEclipse主体です

## Eclipseのソースコード・フォーマッタによるソースコード整形

オープンソースなJava統合開発環境として有名なEclipseには ソースコード・フォーマッタが標準搭載されています。基本的に Java言語の標準的な規約に従ったソースコード整形を行ってくれます。(完全に
Java言語コーディング規約に合致していない点に注意)

## Eclipse Checkstyleプラグイン

転記する気力が萎えてしまいました

* [http://homepage2.nifty.com/igat/igapyon/diary/2004/ig040209.html](http://homepage2.nifty.com/igat/igapyon/diary/2004/ig040209.html)

## Eclipse PMDプラグイン

転記する気力が萎えてしまいました

* [http://homepage2.nifty.com/igat/igapyon/diary/2004/ig040209.html](http://homepage2.nifty.com/igat/igapyon/diary/2004/ig040209.html)

## Eclipse FindBugsプラグイン

* [http://homepage2.nifty.com/igat/igapyon/diary/2004/ig040219.html](http://homepage2.nifty.com/igat/igapyon/diary/2004/ig040219.html)

以下はコマンドライン主体です

## Javaソースファイル整形ツール Artistic Style (astyle)

* Artistic Style (astyle) 1.15.3
  [http://astyle.sourceforge.net/](http://astyle.sourceforge.net/)
  [http://sourceforge.net/projects/astyle/](http://sourceforge.net/projects/astyle/)
  GPLライセンス

通称astyleという、GPLライセンスなJavaソースファイル整形ツールです。astyle -j --style=java -p -s ファイル名.java のようにスイッチを使うと、[Java言語コーディング規約](http://www.tcct.zaq.ne.jp/ayato/programming/java/codeconv_jp/) にそこそこ合致したソースコードを得ることが出来ます。

## Javaソースファイル構文チェックツール checkstyle

* Checkstyle
  [http://checkstyle.sourceforge.net/](http://checkstyle.sourceforge.net/)
  LGPLライセンス

様々な Java構文合致状態をチェックしてくれるツールです。こちらは astyleとは異なり自動整形はしてくれません。その代わり かなり正確に[Java言語コーディング規約](http://www.tcct.zaq.ne.jp/ayato/programming/java/codeconv_jp/)との整合性チェックを報告してくれます。

* java -classpath checkstyle-all-2.3.jar com.puppycrawl.tools.checkstyle.Main
  ファイル名.java

## お好みツール

上記を組み合わせて お好みなバッチを作成して使っています。
st.bat
echo off
rem Javaソースファイルのスタイル整形＆チェックツール
echo astyle実行
astyle -j --style=java -p -s %1 %2 %3 %4 %5 %6 %7 %8 %9
rem checkstyle-all-2.3.jar を CLASSPATHが通ったところに配置してください。
echo checkstyle実行
      java com.puppycrawl.tools.checkstyle.Main %1
      
      diff -urN %1.orig %1

これで st ファイル名.java のように指定すれば、ソースファイル整形とソースファイルのスタイルチェックとがいっぺんに起動できます。

## 更新履歴

* 2004/02/24 Eclipseに対応開始
  
* 2002/07/10 新規作成

----------------------------------------------------------------------------------------------------

## この日記について

* [Share on Twitter](https://twitter.com/intent/tweet?hashtags=igapyon%2Cdiary%2C%E3%81%84%E3%81%8C%E3%81%B4%E3%82%87%E3%82%93&text=%E8%B3%87%E6%96%99%3A+Java%E8%A8%80%E8%AA%9E%E3%82%BD%E3%83%BC%E3%82%B9%E3%83%95%E3%82%A1%E3%82%A4%E3%83%AB%E3%81%AE%E3%82%B9%E3%82%BF%E3%82%A4%E3%83%AB%E3%81%8A%E3%82%88%E3%81%B3%E8%AA%BF%E6%95%B4%E3%83%84%E3%83%BC%E3%83%AB&url=https%3A%2F%2Figapyon.github.io%2Fdiary%2Fmemo%2Fmemojavastyle.html) / [top](../index.html) / [いがぴょんについて](https://igapyon.github.io/diary/memo/memoigapyon.html) / [Powered by Igapyonv3](https://github.com/igapyon/igapyonv3)
* 本サイトの見解は、私 個人のものであり、Wipro は当個人的見解に一切責任を持ちません。 
