
 
     
//月注册人数统计图
var jsonData=$.ajax({
	type:"get", 
	url: 'queryMonthUserRegisterAla',//请求springmvc的地址
    dataType: 'json',
    success: function(data){
    	jsonData=data;
    }
});

var jsonArticle=$.ajax({
	type:"get",
	url:'queryMonthArticleAla',
	dataType:'json',
	success:function(data){
		jsonArticle=data;
	}
});



window.onload = function(){
	   gradientChartOptionsConfiguration = {
	          maintainAspectRatio: false,
	          legend: {
	              display: false
	          },
	          tooltips: {
	            bodySpacing: 4,
	            mode:"nearest",
	            intersect: 0,
	            position:"nearest",
	            xPadding:10,
	            yPadding:10,
	            caretPadding:10
	          },
	          responsive: true,
	          scales: {
	              yAxes: [{
	                display:0,
	                gridLines:0,
	                ticks: {
	                    display: false
	                },
	                gridLines: {
	                    zeroLineColor: "transparent",
	                    drawTicks: false,
	                    display: false,
	                    drawBorder: false
	                }
	              }],
	              xAxes: [{
	                display:0,
	                gridLines:0,
	                ticks: {
	                    display: false
	                },
	                gridLines: {
	                  zeroLineColor: "transparent",
	                  drawTicks: false,
	                  display: false,
	                  drawBorder: false
	                }
	              }]
	          },
	          layout:{
	            padding:{left:0,right:0,top:15,bottom:15}
	          }
	      };
	//填充数据源
	  var canvasSreen = document.getElementById('myChart');
	  var ctx=canvasSreen.getContext('2d');
	  var gradientFill = ctx.createLinearGradient(0, 200, 0, 50);
	  myChart = new Chart(ctx, {
		    type: 'line',
		    responsive: true,
		    data: {
		        labels: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
		        datasets: [{
	                label: "注册人数",
	                borderColor: "#f96332",
	                pointBorderColor: "#FFF",
	                pointBackgroundColor: "#f96332",
	                pointBorderWidth: 2,
	                pointHoverRadius: 4,
	                pointHoverBorderWidth: 1,
	                pointRadius: 4,
	                fill: true,
	                backgroundColor: gradientFill,
	                borderWidth: 2,
	                data: [jsonData.january,jsonData.february,jsonData.march,jsonData.april,jsonData.may,jsonData.june,jsonData.july,jsonData.august,jsonData.september,jsonData.october,jsonData.november,jsonData.december]
	            }]
		    },
		    options: gradientChartOptionsConfiguration
		});
	  
	  //静态填充背景图
	  
	  chartColor = "#FFFFFF";
	 
	  var ctxTwo = document.getElementById('bigDashboardChart').getContext("2d");
	  var gradientStroke = ctx.createLinearGradient(500, 0, 100, 0);
      gradientStroke.addColorStop(0, '#80b6f4');
      gradientStroke.addColorStop(1, chartColor);
      var gradientFill = ctxTwo.createLinearGradient(0, 200, 0, 50);

      gradientFill.addColorStop(0, "rgba(128, 182, 244, 0)");
      gradientFill.addColorStop(1, "rgba(255, 255, 255, 0.24)");

      var myChart = new Chart(ctxTwo, {
          type: 'line',
          data: {
              labels: ["JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"],
              datasets: [{
                  label: "Data",
                  borderColor: chartColor,
                  pointBorderColor: chartColor,
                  pointBackgroundColor: "#1e3d60",
                  pointHoverBackgroundColor: "#1e3d60",
                  pointHoverBorderColor: chartColor,
                  pointBorderWidth: 1,
                  pointHoverRadius: 7,
                  pointHoverBorderWidth: 2,
                  pointRadius: 5,
                  fill: true,
                  backgroundColor: gradientFill,
                  borderWidth: 2,
                  data: [50, 150, 100, 190, 130, 90, 150, 160, 120, 140, 190, 95]
              }]
          },
          options: {
              layout: {
                  padding: {
                      left: 20,
                      right: 20,
                      top: 0,
                      bottom: 0
                  }
              },
              maintainAspectRatio: false,
              tooltips: {
                backgroundColor: '#fff',
                titleFontColor: '#333',
                bodyFontColor: '#666',
                bodySpacing: 4,
                xPadding: 12,
                mode: "nearest",
                intersect: 0,
                position: "nearest"
              },
              legend: {
                  position: "bottom",
                  fillStyle: "#FFF",
                  display: false
              },
              scales: {
                  yAxes: [{
                      ticks: {
                          fontColor: "rgba(255,255,255,0.4)",
                          fontStyle: "bold",
                          beginAtZero: true,
                          maxTicksLimit: 5,
                          padding: 10
                      },
                      gridLines: {
                          drawTicks: true,
                          drawBorder: false,
                          display: true,
                          color: "rgba(255,255,255,0.1)",
                          zeroLineColor: "transparent"
                      }

                  }],
                  xAxes: [{
                      gridLines: {
                          zeroLineColor: "transparent",
                          display: false,

                      },
                      ticks: {
                          padding: 10,
                          fontColor: "rgba(255,255,255,0.4)",
                          fontStyle: "bold"
                      }
                  }]
              }
          }
      });
      
      //用户热评分析图
      var e = document.getElementById("barChartSimpleGradientsNumbers").getContext("2d");

      gradientFill = ctx.createLinearGradient(0, 170, 0, 50);
      gradientFill.addColorStop(0, "rgba(128, 182, 244, 0)");
      gradientFill.addColorStop(1, hexToRGB('#2CA8FF', 0.6));

      var a =  {
        type : "bar",
        responsive: true,
        data : {
          labels : ["Pc","MoBa","Alex","LOL"],
          datasets: [{
            label: "评论条数",
            backgroundColor: gradientFill,
            borderColor: "#2CA8FF",
            pointBorderColor: "#FFF",
            pointBackgroundColor: "#2CA8FF",
            pointBorderWidth: 2,
            pointHoverRadius: 4,
            pointHoverBorderWidth: 1,
            pointRadius: 4,
            fill: true,
            borderWidth: 1,
            data: [80,99,86,96,123,85,100,75,88,90,123,155]
          }]
        },
        options: {
            maintainAspectRatio: false,
            legend: {
                display: false
            },
            tooltips: {
              bodySpacing: 4,
              mode:"nearest",
              intersect: 0,
              position:"nearest",
              xPadding:10,
              yPadding:10,
              caretPadding:10
            },
            responsive: 1,
            scales: {
                yAxes: [{
                  gridLines:0,
                  gridLines: {
                      zeroLineColor: "transparent",
                      drawBorder: false
                  }
                }],
                xAxes: [{
                  display:0,
                  gridLines:0,
                  ticks: {
                      display: false
                  },
                  gridLines: {
                    zeroLineColor: "transparent",
                    drawTicks: false,
                    display: false,
                    drawBorder: false
                  }
                }]
            },
            layout:{
              padding:{left:0,right:0,top:15,bottom:15}
            }
        }
      };
      var viewsChart = new Chart(e,a);
      //游讯上传文章饼图
      var peiCtx = document.getElementById("lineChartExample").getContext("2d");
      var myChart = new Chart(peiCtx, { type: 'pie', data: { labels: ["一月份", "二月份", "三月份", "四月份", "五月份", "六月份","七月份","八月份","九月份","十月份","十一月份","十二月份"], datasets: [{ label: '# of Votes', data: [jsonArticle.januaryUpload,jsonArticle.februaryUpload,jsonArticle.marchUpload,jsonArticle.aprilUpload,jsonArticle.mayUpload,jsonArticle.juneUpload,jsonArticle.julyUpload,jsonArticle.augustUpload,jsonArticle.septemberUpload,jsonArticle.octoberUpload,jsonArticle.novemberUpload,jsonArticle.decemberUpload], backgroundColor: [ 'rgba(255, 99, 132, 0.2)', 'rgba(54, 162, 235, 0.2)', 'rgba(255, 206, 86, 0.2)', 'rgba(75, 192, 192, 0.2)', 'rgba(153, 102, 255, 0.2)', 'rgba(255, 159, 64, 0.2)','rgba(144, 71, 30, 0.2)','rgba(125, 45, 90, 0.2)','rgba(72, 175, 64, 0.2)','rgba(139, 79, 64, 0.2)','rgba(180, 95, 160, 0.2)','rgba(14, 45, 64, 0.2)' ], }] }, options: { responsive: true } });
}; 