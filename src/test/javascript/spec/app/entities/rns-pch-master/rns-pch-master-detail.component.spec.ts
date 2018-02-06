/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

import { JhipsterSampleApplicationTestModule } from '../../../test.module';
import { RNS_PCH_MASTERDetailComponent } from '../../../../../../main/webapp/app/entities/rns-pch-master/rns-pch-master-detail.component';
import { RNS_PCH_MASTERService } from '../../../../../../main/webapp/app/entities/rns-pch-master/rns-pch-master.service';
import { RNS_PCH_MASTER } from '../../../../../../main/webapp/app/entities/rns-pch-master/rns-pch-master.model';

describe('Component Tests', () => {

    describe('RNS_PCH_MASTER Management Detail Component', () => {
        let comp: RNS_PCH_MASTERDetailComponent;
        let fixture: ComponentFixture<RNS_PCH_MASTERDetailComponent>;
        let service: RNS_PCH_MASTERService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [JhipsterSampleApplicationTestModule],
                declarations: [RNS_PCH_MASTERDetailComponent],
                providers: [
                    RNS_PCH_MASTERService
                ]
            })
            .overrideTemplate(RNS_PCH_MASTERDetailComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(RNS_PCH_MASTERDetailComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(RNS_PCH_MASTERService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                spyOn(service, 'find').and.returnValue(Observable.of(new HttpResponse({
                    body: new RNS_PCH_MASTER(123)
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.find).toHaveBeenCalledWith(123);
                expect(comp.rNS_PCH_MASTER).toEqual(jasmine.objectContaining({id: 123}));
            });
        });
    });

});
