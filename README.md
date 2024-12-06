# restaurantProject 

## 專案概述：



## 使用技術
* 後端技術：Java / Spring Boot 3.2.3
* 資料層技術：MyBatis
* Database：MySQL


## 主要功能與技術細節：
*	資料庫表：
  -items: 儲存菜單資訊（名稱、描述、圖片、價格）
 	-orders: 儲存訂單資訊（項目、數量、訂單時間）
  -details 與 item_detail: 儲存菜單的詳細分類
  -bills 與 bill_order: 儲存帳單資訊和訂單與帳單的關聯
 	
* 系統需求與功能設計：
  -菜單管理 (Menu Management)
    CRUD 操作：對 items 表進行操作
    菜單詳細資訊：從 details 和 item_detail 中獲取關聯數據
    分頁與搜索：支持分頁查詢和按名稱/描述/類別搜索
  -帳單管理 (Bill Order Management)
    CRUD 操作：對 bills 和 orders 表進行操作
    檢查帳單：計算帳單的總價並返回訂單詳細內容

