<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : Bai2.xsl
    Created on : August 22, 2020, 9:26 PM
    Author     : USER
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>

    <!-- TODO customize transformation rules 
         syntax recommendation http://www.w3.org/TR/xslt 
    -->
    <xsl:template match="/">
        <html>
            <head>
                <title>Bai2.xsl</title>
            </head>
            <body>
                <table border="1" width="40%" style="margin:auto">
                    <h2  style="text-align:center">Tất cả thông tin máy tính</h2>
                    <tr>
                        <th style="text-align:center">Name</th>
                        <th style="text-align:center">Producer</th>
                        <th style="text-align:center">YearMaking</th>
                        <th style="text-align:center">Price</th>
                    </tr>
                    <xsl:for-each select="Computers/Computer">
                    <tr>
                        <td style="text-align:center">
                        <xsl:value-of select="Name"/>
                        </td>
                        <td style="text-align:center">
                        <xsl:value-of select="Producer"/>
                        </td>
                        <td style="text-align:center">
                        <xsl:value-of select="YearMaking"/>
                        </td>
                        <td style="text-align:center">
                        <xsl:value-of select="Price"/>
                        </td>
                    </tr>
                    </xsl:for-each>
                </table>
                <table border="1" width="40%" style="margin:auto">
                    <h2  style="text-align:center">Máy tính được sản xuất ở Malaysia</h2>
                    <tr>
                        <th style="text-align:center">Name</th>
                        <th style="text-align:center">Producer</th>
                        <th style="text-align:center">YearMaking</th>
                        <th style="text-align:center">Price</th>
                    </tr>
                    <xsl:for-each select="Computers/Computer">
                        <xsl:if test="Producer[@from='Malaysia']">
                    <tr>
                        <td style="text-align:center">
                        <xsl:value-of select="Name"/>
                        </td>
                        <td style="text-align:center">
                        <xsl:value-of select="Producer"/>
                        </td>
                        <td style="text-align:center">
                        <xsl:value-of select="YearMaking"/>
                        </td>
                        <td style="text-align:center">
                        <xsl:value-of select="Price"/>
                        </td>
                    </tr>
                        </xsl:if>
                    </xsl:for-each>
                </table>
                <table border="1" width="40%" style="margin:auto">
                    <h2  style="text-align:center">Máy tính có giá trên 600 USD</h2>
                    <tr>
                        <th style="text-align:center">Name</th>
                        <th style="text-align:center">Producer</th>
                        <th style="text-align:center">YearMaking</th>
                        <th style="text-align:center">Price</th>
                    </tr>
                    <xsl:for-each select="Computers/Computer">
                        <xsl:if test="Price > 600">
                    <tr>
                        <td style="text-align:center">
                        <xsl:value-of select="Name"/>
                        </td>
                        <td style="text-align:center">
                        <xsl:value-of select="Producer"/>
                        </td>
                        <td style="text-align:center">
                        <xsl:value-of select="YearMaking"/>
                        </td>
                        <td style="text-align:center">
                        <xsl:value-of select="Price"/>
                        </td>
                    </tr>
                        </xsl:if>
                    </xsl:for-each>
                </table>
                 <table border="1" width="40%" style="margin:auto">
                    <h2  style="text-align:center">Máy tính sản xuất năm 2018</h2>
                    <tr>
                        <th style="text-align:center">Name</th>
                        <th style="text-align:center">Producer</th>
                        <th style="text-align:center">YearMaking</th>
                        <th style="text-align:center">Price</th>
                    </tr>
                    <xsl:for-each select="Computers/Computer">
                        <xsl:if test="YearMaking = 2018">
                    <tr>
                        <td style="text-align:center">
                        <xsl:value-of select="Name"/>
                        </td>
                        <td style="text-align:center">
                        <xsl:value-of select="Producer"/>
                        </td>
                        <td style="text-align:center">
                        <xsl:value-of select="YearMaking"/>
                        </td>
                        <td style="text-align:center">
                        <xsl:value-of select="Price"/>
                        </td>
                    </tr>
                        </xsl:if>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>
