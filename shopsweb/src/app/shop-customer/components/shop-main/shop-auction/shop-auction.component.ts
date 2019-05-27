import { Component, OnInit, Inject, Renderer2 } from '@angular/core';
import { AuctionForUserService } from 'src/app/shop-customer/services/shop-main/shop-auction/auction-for-user.service';
import { AuctionForUser } from 'src/app/shop-customer/services/shop-main/shop-auction/auction-for-user';
import { ActivatedRoute } from '@angular/router';
import { ConfigService } from 'src/app/config/config.service';
import { DOCUMENT } from '@angular/platform-browser';
declare var $: any;

@Component({
  selector: 'shop-auction',
  templateUrl: './shop-auction.component.html',
  styleUrls: ['./shop-auction.component.scss']
})
export class ShopAuctionComponent implements OnInit {

  auction: AuctionForUser;
  idVariant: number;

  constructor(private _renderer2: Renderer2,
    @Inject(DOCUMENT) private _document,
    private auctionForUserService: AuctionForUserService,
    private route: ActivatedRoute,
    private config: ConfigService
  ) { }

  ngOnInit() {
    this.getData();
  }

  getData(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.auctionForUserService.getAuctionData(id).subscribe(
      result => {
        this.auction = result;
        this.idVariant = this.auction.product.productVariants[0].id;

        let script = this._renderer2.createElement('script');
        script.type = `text/javascript`;
        length = this.auction.product.productVariants[0].productImages.length;
        script.text = `
            {
              $(document).ready(function () {
                  setTimeout(function(){
                    $("#lightslider-photo").lightSlider({
                      item: `+ length + `,
                      loop: false,
                      slideMove: 2,
                      easing: 'cubic-bezier(0.25, 0, 0.25, 1)',
                      speed: 600,
                      pager: false,
                      adaptiveHeight: false,
                      responsive: [
                        {
                          breakpoint: 800,
                          settings: {
                            item: 3,
                            slideMove: 1,
                            slideMargin: 6,
                          }
                        },
                        {
                          breakpoint: 480,
                          settings: {
                            item: 2,
                            slideMove: 1
                          }
                        }
                      ]
                    });
                  },500);
              });
            }
        `;
        this._renderer2.appendChild(this._document.body, script);
      }
    );

  }

}
