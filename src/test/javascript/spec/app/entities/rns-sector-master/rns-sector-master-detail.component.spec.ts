/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

import { JhipsterSampleApplicationTestModule } from '../../../test.module';
import { RNS_SECTOR_MASTERDetailComponent } from '../../../../../../main/webapp/app/entities/rns-sector-master/rns-sector-master-detail.component';
import { RNS_SECTOR_MASTERService } from '../../../../../../main/webapp/app/entities/rns-sector-master/rns-sector-master.service';
import { RNS_SECTOR_MASTER } from '../../../../../../main/webapp/app/entities/rns-sector-master/rns-sector-master.model';

describe('Component Tests', () => {

    describe('RNS_SECTOR_MASTER Management Detail Component', () => {
        let comp: RNS_SECTOR_MASTERDetailComponent;
        let fixture: ComponentFixture<RNS_SECTOR_MASTERDetailComponent>;
        let service: RNS_SECTOR_MASTERService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [JhipsterSampleApplicationTestModule],
                declarations: [RNS_SECTOR_MASTERDetailComponent],
                providers: [
                    RNS_SECTOR_MASTERService
                ]
            })
            .overrideTemplate(RNS_SECTOR_MASTERDetailComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(RNS_SECTOR_MASTERDetailComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(RNS_SECTOR_MASTERService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                spyOn(service, 'find').and.returnValue(Observable.of(new HttpResponse({
                    body: new RNS_SECTOR_MASTER(123)
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.find).toHaveBeenCalledWith(123);
                expect(comp.rNS_SECTOR_MASTER).toEqual(jasmine.objectContaining({id: 123}));
            });
        });
    });

});
